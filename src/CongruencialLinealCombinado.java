import java.util.ArrayList;

public class CongruencialLinealCombinado {
    private double a1, m1, a2, m2;

    public CongruencialLinealCombinado(double a1, double m1, double a2, double m2) {
        this.a1 = a1;
        this.m1 = m1;
        this.a2 = a2;
        this.m2 = m2;
    }

    public ArrayList<ComplexRandomNumber> run(int iterations){ return result(iterations);}

    public ArrayList<ComplexRandomNumber> result(int iterations) {
        ArrayList<ComplexRandomNumber> randomNums = new ArrayList<>();
        ComplexRandomNumber randomNumber = new ComplexRandomNumber();
        for (int i = 0; i < iterations; i++) {
            if(i == 0){
                double seed = m1-1/m1;
                randomNumber.setSeed1(seed);
                randomNumber.setSeed2(seed);
            }
            randomNumber.setIteration(i);
            double generator = (a1 * randomNumber.getSeed1()) % m1;
            randomNumber.setRandomNum1(generator);
            generator = (a2 * randomNumber.getSeed2()) % m2;
            randomNumber.setRandomNum2(generator);
            double tmp = (((randomNumber.getRandomNum1()- randomNumber.getRandomNum2())%(m1-1))/m1);
            if (tmp < 0){
                tmp = tmp * (-1);
            }
            randomNumber.setActualRandomNum(tmp);
            randomNums.add(new ComplexRandomNumber(i, randomNumber.getActualRandomNum(), randomNumber.getRandomNum1(), randomNumber.getRandomNum2(), randomNumber.getSeed1(), randomNumber.getSeed2()));
            randomNumber.setSeed1(randomNumber.getRandomNum1());
            randomNumber.setSeed2(randomNumber.getRandomNum2());
            }
        return randomNums;
    }
}
