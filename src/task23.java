public class task23 {
    private int[] parts;

    public task23(int realPart, int imaginaryPart) {
        parts = new int[2];
        parts[0] = realPart;
        parts[1] = imaginaryPart;
    }

    public task23 add(task23 other) {
        int real = this.parts[0] + other.parts[0];
        int imaginary = this.parts[1] + other.parts[1];
        return new task23(real, imaginary);
    }

    public task23 subtract(task23 other) {
        int real = this.parts[0] - other.parts[0];
        int imaginary = this.parts[1] - other.parts[1];
        return new task23(real, imaginary);
    }

    public task23 multiply(task23 other) {
        int real = this.parts[0] * other.parts[0] - this.parts[1] * other.parts[1];
        int imaginary = this.parts[0] * other.parts[1] + this.parts[1] * other.parts[0];
        return new task23(real, imaginary);
    }

    public int getRealPart() {
        return parts[0];
    }

    public int getImaginaryPart() {
        return parts[1];
    }

    public void setRealPart(int realPart) {
        parts[0] = realPart;
    }

    public void setImaginaryPart(int imaginaryPart) {
        parts[1] = imaginaryPart;
    }

    @Override
    public String toString() {
        return parts[0] + " + " + parts[1] + "i";
    }
}