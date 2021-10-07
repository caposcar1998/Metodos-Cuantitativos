import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KolmogorovSmirnov {
    private List<Double> nums;
    private ArrayList<Double> sortedNums;
    private double dPlus, dMinus;

    private double[] iM1, iM2, iM3, iM4 = new double[nums.size()];

    public KolmogorovSmirnov(List<Double> nums) {
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

    public double getDPlus() {return dPlus};

    public void setdPlus(double dPlus) { this.dPlus = dPlus; }

    public double getDMinus() {return dMinus};

    public void setdMinus(double dMinus) { this.dMinus = dMinus; }

    public void run(){
        sortedNums = new ArrayList<>(nums);
        Collections.sort(sortedNums);
        for (int i=0; i< nums.size(); i++){
            iM1[i] = sortedNums.get(i);
            iM2[i] = i / sortedNums.size();
            iM3[i] = Math.abs(iM2[i]-iM1[i]);
            if(i == 0){
                //Caso para el primer renglón de la tabla
                iM4[i] = Math.abs(iM1[i]);
            }
            else{
                //Resto renglones
                iM4[i] = Math.abs(iM1[i]-iM2[i-1]);
            }
        }
        Arrays.sort(iM3);
        Arrays.sort(iM4);
        setdPlus(iM3[iM3.length-1]);
        setdMinus(iM4[iM4.length-1]);
    }
}
