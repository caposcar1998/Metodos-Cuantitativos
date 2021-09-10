import java.util.ArrayList;

public class CongruencialMixto {
    private int x0, a, c, m;

    public CongruencialMixto(int x0, int a, int c, int m) {
        this.x0 = x0;
        this.a = a;
        this.c = c;
        this.m = m;
    }

    public int getX0() {
        return x0;
    }

    public void setX0(int x0) {
        this.x0 = x0;
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

    public void run() {
        System.out.println(checkHullDobell());
    }

    public

    public ArrayList<String> checkHullDobell() {
        ArrayList<String> warnings = new ArrayList<>();

        // Sea cy mprimos relativo  (el máximo común divisor entero cy mes 1)
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

    // Si qes un número primo que divide a m; entonces, q divide a (a-1)
    public boolean hullDobellCondition2() {
        int smallest = Math.min(m, a - 1);
        for (int q = 0; q <= smallest; q++) {
            if (isPrime(q)) {
                if (m % q == 0 && (a - 1) % q == 0){
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
        // 0 no es coprimo con ningún número
        if (num1 == 0 || num2 == 0) {
            return false;
        }
        // Se revisarán todos los posibles números hasta alcanzar el más chico
        int smallest = Math.min(num1, num2);
        // Revisa si los números son ambos divisibles por el mismo número
        for (int i = 2; i <= smallest; i++) {
            // Si lo son, no son primos relativos
            if (num1 % i == 0 && num2 % i == 0) {
                return false;
            }
        }
        return true;
    }
}