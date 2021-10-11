import java.util.ArrayList;
import java.util.List;

public class Lab {
    public static void main(String[] args) {
        System.out.println("Prueba");

//        List<Double> nums = new ArrayList<Double>();
//        nums.add(0.05);
//        nums.add(0.14);
//        nums.add(0.44);
//        nums.add(0.81);
//        nums.add(0.93);
//
//        KolmogorovSmirnov decoder = new KolmogorovSmirnov(nums);
//        decoder.run();
//        System.out.println("D+ : " + decoder.getDPlus());
//        System.out.println("D- : " + decoder.getDMinus());

        ArrayList<ComplexRandomNumber> randomNums = new ArrayList<>();
        CongruencialLinealCombinado generator = new CongruencialLinealCombinado(5,7,6,8);
        randomNums = generator.run(2);

        for(int i=0; i<randomNums.size(); i++){
            System.out.println("Value i=" + i + ": " + randomNums.get(i).toString());
        }
    }
}
