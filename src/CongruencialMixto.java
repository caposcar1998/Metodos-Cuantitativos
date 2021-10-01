import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CongruencialMixto {
    private int seed, a, c, m;

    public CongruencialMixto(int seed, int a, int c, int m) {
        this.seed = seed;
        this.a = a;
        this.c = c;
        this.m = m;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public ArrayList<RandomNumber> run(int iterations) {
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

    public ArrayList<String> checkHullDobell() {
        ArrayList<String> warnings = new ArrayList<>();

        // Sea c y m primos relativos (el máximo común divisor entero c y m es 1)
        if (!areRelativePrimes(c, m)) {
            warnings.add("Condición 1: c y m no son primos relativos");
        }

        // Si q es un número primo que divide a m; entonces, q divide a (a-1)
        if (!hullDobellCondition2()) {
            warnings.add("Condición 2: no existe q que divida a m y a (a-1)");
        }

        // Si 4 divide a m; entonces, 4 divide a (a-1)
        boolean condition3 = m % 4 == 0 && (a - 1) % 4 == 0;
        if (!condition3) {
            warnings.add("Condición 3: 4 no divide a m o no divide a (a-1)");
        }

        return warnings;
    }

    // Si q es un número primo que divide a m; entonces, q divide a (a-1)
    public boolean hullDobellCondition2() {
        int smallest = Math.min(m, a - 1);
        for (int q = 0; q <= smallest; q++) {
            if (isPrime(q)) {
                if (m % q == 0 && (a - 1) % q == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isPrime(int num) {
        // 0 y 1 no son primos
        if (num < 2) {
            return false;
        }
        // Revisa si num is divisible por cualquier valor entre 2 y num - 1
        for (int i = 2; i < num; i++) {
            // Si es divisible por alguno, no es primo
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean areRelativePrimes(int num1, int num2) {
        // 0 no es primo relativo con ningún número
        if (num1 == 0 || num2 == 0) {
            return false;
        }
        // Se revisarán todos los posibles números hasta alcanzar el más chico
        int smallest = Math.min(num1, num2);
        // Revisa si los números son ambos divisibles por el mismo número además de 1
        for (int i = 2; i <= smallest; i++) {
            // Si lo son, no son primos relativos
            if (num1 % i == 0 && num2 % i == 0) {
                return false;
            }
        }
        return true;
    }
}