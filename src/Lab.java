import java.util.ArrayList;
import java.util.List;

public class Lab {
    public static void main(String[] args) {
        System.out.println("Prueba");

        List<Double> nums = new ArrayList<Double>();
        nums.add(0.05);
        nums.add(0.14);
        nums.add(0.44);
        nums.add(0.81);
        nums.add(0.93);

        KolmogorovSmirnov decoder = new KolmogorovSmirnov(nums);
        decoder.run();
        System.out.println("D+ : " + decoder.getDPlus());
        System.out.println("D- : " + decoder.getDMinus());
    }
}
