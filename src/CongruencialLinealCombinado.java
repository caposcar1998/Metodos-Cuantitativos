import java.util.ArrayList;

public class CongruencialLinealCombinado {
    private int a1, m1, a2, m2;

    public CongruencialLinealCombinado(int a1, int m1, int a2, int m2) {
        this.a1 = a1;
        this.m1 = m1;
        this.a2 = a2;
        this.m2 = m2;
    }

    public ArrayList<ComplexRandomNumber> run(int iterations){ return result(iterations);}

    public ArrayList<ComplexRandomNumber> result(int iterations) {
        ArrayList<ComplexRandomNumber> randomNums = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            ComplexRandomNumber randomNumber = new ComplexRandomNumber();
            if(i == 0){
                double seed = (double)m1-1/m1;
                randomNumber.setSeed1(seed);
                randomNumber.setSeed2(seed);
            }
            randomNumber.setIteration(i);
            double generator = (a1 * randomNumber.getSeed1()) % m1;
            randomNumber.setRandomNum1(generator);
            generator = (a2 * randomNumber.getSeed2()) % m2;
            randomNumber.setRandomNum2(generator);
            randomNumber.setActualRandomNum(((randomNumber.getRandomNum1()- randomNumber.getRandomNum2())%(m1-1))/m1);
            randomNumber.setSeed1(randomNumber.getRandomNum1());
            randomNumber.setSeed2(randomNumber.getRandomNum2());
            randomNums.add(randomNumber);
        }
        return randomNums;
    }
}
