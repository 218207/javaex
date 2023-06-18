import java.util.Scanner;

public class task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt(); // Ввод числа с клавиатуры
        scanner.close();

        long factorial = calculateFactorial(number); // Вызываем метод для вычисления факториала
        System.out.println("Факториал числа " + number + " равен " + factorial);
    }

    public static long calculateFactorial(int n) {
        if (n == 0) {
            return 1; // Факториал 0 равен 1
        } else {
            return n * calculateFactorial(n - 1); // Рекурсивный вызов метода для уменьшения числа на 1
        }
    }
}