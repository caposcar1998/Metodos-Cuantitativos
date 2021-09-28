import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        System.out.println("Centros cuadrados");
        CentrosCuadrados cc = new CentrosCuadrados(3708, 7);
        cc.run();
        System.out.println("Congruencia lineal");
        CongruenciaLineal cl = new CongruenciaLineal(4, 5, 7, 8);
        cl.run();
        System.out.println("Congruencia mixta");
        CongruencialMixto cm = new CongruencialMixto(4, 5, 7, 8);
        cm.run();
        */
        Page pg = new Page();
        pg.run();

/*
        System.out.println("Generador Multiplicativo");
        GeneradorMultiplicativo gm = new GeneradorMultiplicativo(5, 5, 32);
        gm.run();

        Double[] testChi = {
                0.411,0.11,0.191,0.037,0.12,0.575,0.73,
                0.281,0.408,0.541,0.995,0.233,0.553,0.469,
                0.81,0.598,0.434,0.668,0.719,0.791,0.213,
                0.77,0.671,0.156,0.383,0.711,0.914,0.826,0.018,0.984
        };

        List<Double> testChiList = Arrays.asList(testChi);
        ChiCuadrada chi = new ChiCuadrada(testChiList, 0.05);
        double chiSquare = chi.run();
        System.out.println("Chi cuadrada calculada: " + chiSquare);
        System.out.println("Chi cuadrada de table: " + chi.getChiSquareFromTable());
        if (chiSquare < chi.getChiSquareFromTable()) {
            System.out.println("Chi cuadrada: Se acepta hipótesis nula");
        } else {
            System.out.println("Chi cuadrada: Se rechaza hipótesis nula");
        }
        */

    }


}
