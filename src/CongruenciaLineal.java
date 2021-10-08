import java.util.ArrayList;

public class CongruenciaLineal {
    private int seed, a, c, m;

    public CongruenciaLineal(int seed, int a, int c, int m) {
        this.seed = seed;
        this.a = a;
        this.c = c;
        this.m = m;
    }

    public ArrayList<RandomNumber> run(int iterations){
        return generate(iterations);
    }

    public ArrayList<RandomNumber> generate(int iterations) {
        ArrayList<RandomNumber> randomNums = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            RandomNumber randomNumber = new RandomNumber();
            randomNumber.setSeed(seed);
            randomNumber.setIteration(i);
            int generator = ((a * seed) + c) % m;
            randomNumber.setRandomNum(generator);
            randomNumber.setActualRandomNum(generator / Double.valueOf(m));
            seed = generator;
            randomNums.add(randomNumber);
        }
        return randomNums;
    }
}
