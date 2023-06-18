package task16;
public class GeometricProgression implements Progress {
    private double a;
    private double r;

    public GeometricProgression(double a, double r) {
        this.a = a;
        this.r = r;
    }

    public double getElement(int n) {
        return a * Math.pow(r, n - 1);
    }

    public double getSum(int n) {
        return a * (1 - Math.pow(r, n)) / (1 - r);
    }
}