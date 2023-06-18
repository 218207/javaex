package task16;
public class ArithmeticProgression implements Progress {
    private double a;
    private double d;

    public ArithmeticProgression(double a, double d) {
        this.a = a;
        this.d = d;
    }

    public double getElement(int n) {
        return a + (n - 1) * d;
    }

    public double getSum(int n) {
        return n * (2 * a + (n - 1) * d) / 2;
    }
}