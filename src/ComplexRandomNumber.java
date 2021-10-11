public class ComplexRandomNumber {
    int iteration;
    double actualRandomNum, randomNum1, randomNum2, seed1, seed2;

    public ComplexRandomNumber() { }
    public ComplexRandomNumber(int iteration, double actualRandomNum, double randomNum1, double randomNum2, double seed1, double seed2) {
        this.iteration = iteration;
        this.actualRandomNum = actualRandomNum;
        this.randomNum1 = randomNum1;
        this.randomNum2 = randomNum2;
        this.seed1 = seed1;
        this.seed2 = seed2;
    }

    public int getIteration() {
        return iteration;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    public double getRandomNum1() {
        return randomNum1;
    }

    public void setRandomNum1(double randomNum1) {
        this.randomNum1 = randomNum1;
    }

    public double getRandomNum2() {
        return randomNum2;
    }

    public void setRandomNum2(double randomNum2) {
        this.randomNum2 = randomNum2;
    }

    public double getSeed1() {
        return seed1;
    }

    public void setSeed1(double seed1) {
        this.seed1 = seed1;
    }

    public double getSeed2() {
        return seed2;
    }

    public void setSeed2(double seed2) {
        this.seed2 = seed2;
    }

    public double getActualRandomNum() {
        return actualRandomNum;
    }

    public void setActualRandomNum(double actualRandomNum) {
        this.actualRandomNum = actualRandomNum;
    }

    @Override
    public String toString() {
        return "RandomNumber{" +
                "iteration=" + iteration +
                ", seed1=" + seed1 +
                ", seed2=" + seed2 +
                ", randomNum1=" + randomNum1 +
                ", randomNum2=" + randomNum2 +
                ", actualRandomNum=" + actualRandomNum +
                '}';
    }
}
