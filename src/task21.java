import java.util.Random;
import java.util.Scanner;


public class task21 {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            int secretNumber = random.nextInt(10) + 1;
            int attempts = 3;
            boolean guessed = false;

            while (attempts > 0) {
                System.out.print("Введите число: ");
                int guess;

                try {
                    guess = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Некорректный ввод. Введите целое число от 1 до 10.");
                    scanner.nextLine();
                    continue;
                }

                if (guess == secretNumber) {
                    System.out.println("Вы угадали число.");
                    guessed = true;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Загаданное число больше, чем введенное.");
                } else {
                    System.out.println("Загаданное число меньше, чем введенное.");
                }

                attempts--;
            }

            if (!guessed) {
                System.out.println("Вы проиграли. Загаданное число было: " + secretNumber);
            }

            System.out.print("Хотите сыграть еще раз? (Да/Нет): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("да")) {
                break;
            }
        }

        System.out.println("Спасибо за игру. До свидания!");
        scanner.close();
    }


}
