import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.*;

public class ChiCuadrada {
    private List<Double> nums;
    private ArrayList<Double> sortedNums;
    private double significance, chiSquare, chiSquareFromTable;
    HashMap<Double, HashMap<Integer, Double>> chiSquareTable;

    public ChiCuadrada(List<Double> nums, double significance) {
        this.nums = nums;
        this.significance = significance;
    }

    public List<Double> getNums() {
        return nums;
    }

    public void setNums(List<Double> nums) {
        this.nums = nums;
    }

    public ArrayList<Double> getSortedNums() {
        return sortedNums;
    }

    public void setSortedNums(ArrayList<Double> sortedNums) {
        this.sortedNums = sortedNums;
    }

    public double getSignificance() {
        return significance;
    }

    public void setSignificance(double significance) {
        this.significance = significance;
    }

    public double getChiSquare() {
        return chiSquare;
    }

    public void setChiSquare(double chiSquare) {
        this.chiSquare = chiSquare;
    }

    public double getChiSquareFromTable() {
        return chiSquareFromTable;
    }

    public void setChiSquareFromTable(double chiSquareFromTable) {
        this.chiSquareFromTable = chiSquareFromTable;
    }

    // true = hip nula no se rechaza, false = hip nula se rechaza
    public double run() {
        sortedNums = new ArrayList<>(nums);
        Collections.sort(sortedNums);

        double range = sortedNums.get(sortedNums.size() - 1) - sortedNums.get(0);
        double k = Math.floor(1 + (3.322 * Math.log10(nums.size())));
        double classRange = (double) Math.ceil(100 * range / k) / 100;

        ArrayList<ChiCuadradaClaseK> classes = new ArrayList<>();

        // Generar las clases con base en los rangos
        double classStart = 0;
        double classEnd = 0;
        for (int i = 1; i <= k; i++) {
            classEnd = classStart + classRange;
            int f0Abs = countItemsInClassRange(classStart, classEnd);
            ChiCuadradaClaseK ccClass = new ChiCuadradaClaseK(f0Abs, classStart, classEnd);
            classes.add(ccClass);
            classStart = classEnd;
        }

        // Revisar si algunas clases tienen menos de 5, si es así, combinar
        int classWithLessThan5;
        do {
            classWithLessThan5 = checkIfClassWithLessThan5(classes);
            // -1 es que no encontró ninguna y 0 porque si es la primera clase, se trata diferente
            if (classWithLessThan5 != -1 && classWithLessThan5 != 0) {
                ChiCuadradaClaseK merged = mergeClasses(classes.get(classWithLessThan5 - 1),
                        classes.get(classWithLessThan5));
                classes = reassignClasses(classes, merged, classWithLessThan5 - 1, classWithLessThan5);
                // System.out.println(classes);
            }
        } while (classWithLessThan5 != -1 && classWithLessThan5 != 0);

        
        // Mismo feEsperado para todos, porque es una distrib uniforme
        double feEsperado;
        chiSquare = 0;
        for (ChiCuadradaClaseK cc : classes) {
            feEsperado = nums.size() * (cc.getClassEnd() - cc.getClassStart());
            chiSquare += Math.pow(cc.getF0Abs() - feEsperado, 2) / feEsperado;
        }
        
        readCsv();
        int v = classes.size() - 1;
        try {
            chiSquareFromTable = chiSquareTable.get(significance).get(v);
        } catch (Exception e) {
            String message = "La significacia no existe";
            if (v < 1) {
                message = "Por favor genera al menos dos clases K";
            }
            throw new IllegalArgumentException(message);
        }
        return chiSquare;
    }

    public int countItemsInClassRange(double start, double end) {
        int count = 0;
        for (double num : sortedNums) {
            if (start == 0 && num == 0) {
                count++;
            }
            if (num > start && num <= end) {
                count++;
            }
        }
        return count;
    }

    public ChiCuadradaClaseK mergeClasses(ChiCuadradaClaseK cc1, ChiCuadradaClaseK cc2) {
        ChiCuadradaClaseK merged = new ChiCuadradaClaseK();
        merged.setClassStart(cc1.getClassStart());
        merged.setClassEnd(cc2.getClassEnd());
        merged.setF0Abs(cc1.getF0Abs() + cc2.getF0Abs());
        return merged;
    }

    public int checkIfClassWithLessThan5(ArrayList<ChiCuadradaClaseK> classes) {
        for (int i = classes.size() - 1; i >= 0; i--) {
            if (classes.get(i).getF0Abs() < 5) {
                return i;
            }
        }
        return -1;
    }

    // La lista debe reasignarse porque un elemento va a desaparecer, ya que se
    // combinó con otro
    public ArrayList<ChiCuadradaClaseK> reassignClasses(ArrayList<ChiCuadradaClaseK> classes, ChiCuadradaClaseK merged,
            int whichToReplace, int whichToRemove) {
        ArrayList<ChiCuadradaClaseK> reassigned = new ArrayList<>();
        for (int i = 0; i < classes.size(); i++) {
            if (i == whichToReplace) {
                reassigned.add(merged);
            } else if (i == whichToRemove) {
                // no se agrega
            } else {
                reassigned.add(classes.get(i));
            }
        }
        return reassigned;
    }

    public void readCsv() {
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL("https://gist.githubusercontent.com/Akio789/c23df307717f76f77e191813fae3104e/raw/7fb85a2afaedde38b2c017ff17399d2ff8af32ba/chiSquareTable.csv");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {
                for (String line; (line = reader.readLine()) != null; ) {
                    result.append(line);
                }
            }

            ArrayList<String> rawCsv = new ArrayList(Arrays.asList(result.toString().split("-")));

            chiSquareTable = new HashMap<>();
            ArrayList<Double> headerHelper = new ArrayList<>();

            // Leer headers e inicializar hash map
            /*
            {
                0.995: {},
                0.99: {},
                ...
            }
             */

            String headers = rawCsv.get(0);
            for (String col: headers.split(",")) {
                try{
                    chiSquareTable.put(Double.parseDouble(col), new HashMap<>());
                    headerHelper.add(Double.parseDouble(col));
                } catch (NumberFormatException e) {
                    System.out.println("Celda vacía, todo bien");
                }
            }

            // Popular hash map
            /*
            {
                0.995: {1=3.97E-5, 2=0.01, 3=0.072, ...},
                0.99: {1=3.97E-5, 2=0.01, 3=0.072, ...},
                ...
            }
             */
            int i = 0;
            for (int k = 1; k < 51; k++) {
                String line = rawCsv.get(k);
                String[] row = line.split(",");
                int degreeOfFreedom = Integer.parseInt(row[0]);
                for (int j = 1; j < 16; j++) {
                    String cell = row[j];
                    try {
                        double targetSignificance = headerHelper.get(i);
                        chiSquareTable.get(targetSignificance).put(degreeOfFreedom, Double.parseDouble(cell));
                        i++;
                    } catch (NumberFormatException e) {
                        System.out.println("Celda vacía, todo bien");
                    }
                }
                i = 0;
            }

        } catch (FileNotFoundException | MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}