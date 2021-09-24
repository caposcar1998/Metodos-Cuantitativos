import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        System.out.println("Centros cuadrados");
        CentrosCuadrados cc = new CentrosCuadrados(3708,7);
        cc.run();
        System.out.println("Congruencia lineal");
        CongruenciaLineal cl = new CongruenciaLineal(4,5,7,8);
        cl.run();
        System.out.println("Congruencia mixta");
        CongruencialMixto cm = new CongruencialMixto(4, 5, 7, 8);
        cm.run();
        System.out.println("Generador Multiplicativo");
        GeneradorMultiplicativo gm = new GeneradorMultiplicativo(5,5,32);
        gm.run();
        */

        Double[] testChi = {
                8.223, 0.836, 2.634, 4.778, 0.406, 0.517, 2.330, 2.563, 0.511, 6.426,
                2.230, 3.810, 1.624, 1.507, 2.343, 1.458, 0.774, 0.023, 0.225, 3.214,
                2.920, 0.968, 0.333, 4.025, 0.538, 0.234, 3.323, 3.334, 2.325, 7.514,
                0.761, 4.490, 1.514, 1.064, 5.088, 1.401, 0.294, 3.491, 2.921, 0.334,
                1.064, 0.186, 2.782, 3.246, 5.587, 0.685, 1.725, 1.267, 1.702, 1.849,
        };

        List<Double> testChiList = Arrays.asList(testChi);
        ChiCuadrada chi = new ChiCuadrada(testChiList);
        chi.run();
    }
}
