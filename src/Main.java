public class Main {
    public static void main(String[] args) {
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

    }
}
