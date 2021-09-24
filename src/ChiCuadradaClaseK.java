public class ChiCuadradaClaseK {
    private int f0Abs;
    private double classStart, classEnd;

    public ChiCuadradaClaseK(int f0Abs, double classStart, double classEnd) {
        this.f0Abs = f0Abs;
        this.classStart = classStart;
        this.classEnd = classEnd;
    }

    public ChiCuadradaClaseK() {}

    public int getF0Abs() {
        return f0Abs;
    }

    public void setF0Abs(int f0Abs) {
        this.f0Abs = f0Abs;
    }

    public double getClassStart() {
        return classStart;
    }

    public void setClassStart(double classStart) {
        this.classStart = classStart;
    }

    public double getClassEnd() {
        return classEnd;
    }

    public void setClassEnd(double classEnd) {
        this.classEnd = classEnd;
    }

    @Override
    public String toString() {
        return "ChiCuadradaClaseK{" +
                "f0Abs=" + f0Abs +
                ", classStart=" + classStart +
                ", classEnd=" + classEnd +
                '}';
    }
}
