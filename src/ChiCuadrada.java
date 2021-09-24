import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ChiCuadrada {
    private List<Double> nums;
    private ArrayList<Double> sortedNums;

    public ChiCuadrada(List<Double> nums) {
        this.nums = nums;
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

    public void run() {
        sortedNums = new ArrayList<>(nums);
        Collections.sort(sortedNums);

        double range = sortedNums.get(sortedNums.size() - 1)  - sortedNums.get(0);
        double k = Math.round(1 + (3.222 * Math.log10(nums.size())));
        double v = k - 1;
        //double classRange = range / k;
        double classRange = 1.5;

        ArrayList<ChiCuadradaClaseK> classes = new ArrayList<>();

        // Generar las clases con base en los rangos
        double classStart = 0;
        double classEnd = 0;
        for (int i = 1; i <= k ; i++) {
            classEnd = classStart + classRange;
            int f0Abs = countItemsInClassRange(classStart, classEnd);
            ChiCuadradaClaseK ccClass = new ChiCuadradaClaseK(f0Abs,classStart, classEnd);
            classes.add(ccClass);
            classStart = classEnd;
        }

        // System.out.println(classes);

        // Revisar si algunas clases tienen menos de 5, si es así, combinar
        int classWithLessThan5;
        do {
            classWithLessThan5 = checkIfClassWithLessThan5(classes);
            // -1 es que no encontró ninguna
            if (classWithLessThan5 != -1) {
                ChiCuadradaClaseK merged = mergeClasses(classes.get(classWithLessThan5 - 1), classes.get(classWithLessThan5));
                classes = reassignClasses(classes, merged, classWithLessThan5 - 1, classWithLessThan5);
                // System.out.println(classes);
            }
        } while(classWithLessThan5 != -1);

        // Mismo feEsperado para todos, porque es una distrib uniforme
        double feEsperado = (double) nums.size() / classes.size();
        double chiCuadrada = 0;
        for (ChiCuadradaClaseK cc: classes) {
            chiCuadrada += Math.pow(cc.getF0Abs() - feEsperado, 2) / feEsperado;
        }
        System.out.println(chiCuadrada);
    }

    public int countItemsInClassRange(double start, double end) {
        int count = 0;
        for (double num: sortedNums) {
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
        for (int i = classes.size() - 1; i > 0; i--) {
            if (classes.get(i).getF0Abs() < 5) {
                return i;
            }
        }
        return -1;
    }

    // La lista debe reasignarse porque un elemento va a desaparecer, ya que se combinó con otro
    public ArrayList<ChiCuadradaClaseK> reassignClasses(
            ArrayList<ChiCuadradaClaseK> classes,
            ChiCuadradaClaseK merged,
            int whichToReplace,
            int whichToRemove) {
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
}
