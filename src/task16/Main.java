package task16;
public class Main {
    public static void main(String[] args) {
        // Создаем арифметическую прогрессию с a = 1, d = 2
        ArithmeticProgression ap = new ArithmeticProgression(1, 2);

        // Вычисляем и выводим на экран первые 5 элементов арифметической прогрессии
        for (int i = 1; i <= 5; i++) {
            double element = ap.getElement(i);
            System.out.println("Элемент " + i + ": " + element);
        }

        // Вычисляем и выводим на экран сумму первых 5 элементов арифметической прогрессии
        double sum = ap.getSum(5);

        System.out.println("Сумма первых 5 элементов арифметической прогрессии: " + sum + "\n");

        // Создаем геометрическую прогрессию с a = 2, r = 3
        GeometricProgression gp = new GeometricProgression(2, 3);

        // Вычисляем и выводим на экран первые 5 элементов геометрической прогрессии
        for (int i = 1; i <= 5; i++) {
            double element = gp.getElement(i);
            System.out.println("Элемент " + i + ": " + element);
        }

        // Вычисляем и выводим на экран сумму первых 5 элементов геометрической прогрессии
        sum = gp.getSum(5);
        System.out.println("Сумма первых 5 элементов геометрической прогрессии : " + sum);
    }
}
