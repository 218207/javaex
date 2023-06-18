package task14;

import task14.RightTriangle;

public class Test {
    public static void calculateTriangles() {
        Triangle t = new Triangle(3, 4, 5);
        System.out.println("Perimeter: " + t.getPerimeter()); // 12.0
        System.out.println("Area: " + t.getArea()); // 6.0

        RightTriangle rt = new RightTriangle(3, 4);
        System.out.println("Perimeter: " + rt.getPerimeter()); // 12.0
        System.out.println("Area: " + rt.getArea()); // 6.0
        System.out.println("Hypotenuse: " + rt.getHypotenuse()); // 5.0
    }

    public static void main(String[] args) {
        calculateTriangles();
    }
}
