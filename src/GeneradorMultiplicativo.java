import java.util.ArrayList;

public class GeneradorMultiplicativo {
    private int seed, a, m;

    public GeneradorMultiplicativo(int seed, int a, int m) {
        this.seed = seed;
        this.a = a;
        this.m = m;
    }

    public void run(){
        System.out.println("Resultado: " + result(8));
    }

    public ArrayList<RandomNumber> result(int iterations) {
        ArrayList<RandomNumber> randomNums = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            RandomNumber randomNumber = new RandomNumber();
            randomNumber.setSeed(seed);
            randomNumber.setIteration(i);
            int generator = (a * seed) % m;
            randomNumber.setRandomNum(generator);
            randomNumber.setActualRandomNum(generator / Double.valueOf(m));
            seed = generator;
            randomNums.add(randomNumber);
        }
        return randomNums;
    }


}
