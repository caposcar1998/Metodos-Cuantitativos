import java.util.ArrayList;


public class CentrosCuadrados {
    private int seed, iteracions;

    public CentrosCuadrados(int seed, int iteracions){
        this.seed=seed;
        this.iteracions=iteracions;
    }

    public ArrayList<RandomNumber> run(){
        return metodo(seed,iteracions);
    }

    public  ArrayList<RandomNumber>  metodo(int seed, int iteracions){
        ArrayList<RandomNumber> randomNums = new ArrayList<>();
        int generator =0;
        int sizeSeed = 0;
        int sizeGenerator = 0;
        int randomNumber = 0;
        String randomN = "";
        int randomNumberString = 0;
        if(Integer.toString(seed).length() == 4){
            for (int i =0; i<=iteracions;i++){
                RandomNumber ran = new RandomNumber();
                ran.setSeed(seed);
                //Se obtiene numero generador
                generator = seed * seed;
                ran.setIteration(i);
                ran.setRandomNum(generator);
                //Se obtiene random
                //Largos de semillas y de generador
                sizeSeed = Integer.toString(seed).length();
                sizeGenerator = Integer.toString(generator).length();
                //Se restan y se dividen entre 2
                //Se obtienen numeros a eliminar al inicio, se obtiene la dif entre generador y semilla y se divide entre 2
                randomNumber = (sizeGenerator-sizeSeed)/2;
                randomN = Integer.toString(generator);
                //Al final se elimina lo que queda de quitar el inicio, esto con lo se que quito al inicio y lo que tiene que valer la siguiente semilla
                randomNumberString = Integer.parseInt(randomN.substring(randomNumber,randomNumber+sizeSeed));
                //Se obtiene Ri al dividir entre 10 mil
                ran.setActualRandomNum((double)randomNumberString/10000);
                //Se reasigna valor de la semilla
                seed = randomNumberString;
                randomNums.add(ran);
            }
        }else{
            System.out.println("La semilla tiene que ser siempre de 4 digitos");
        }
        return randomNums;
    }
}
