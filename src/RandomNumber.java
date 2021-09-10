public class RandomNumber {
    int iteration, randomNum, seed;
    double actualRandomNum;

    public RandomNumber() { }

    public int getIteration() {
        return iteration;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    public int getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(int randomNum) {
        this.randomNum = randomNum;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
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
                ", seed=" + seed +
                ", randomNum=" + randomNum +
                ", actualRandomNum=" + actualRandomNum +
                '}';
    }
}
