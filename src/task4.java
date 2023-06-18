//4. Написать калькулятор для строковых выражений вида "<число> <операция> <число>",
//где <число> - положительное целое число меньшее 10, записанное словами, например, "четыре",
//<арифметическая операция> - одна из операций "плюс", "минус", "умножить". Результат
//выполнения операции вернуть в виде текстового представления числа. Пример: "пять плюс
//четыре" --> "девять".


import java.util.*;

public class task4 {
    public static void main(String[] args) {
        HashMap<String, Integer> numbers = new HashMap<>();
        numbers.put("ноль", 0);
        numbers.put("один", 1);
        numbers.put("два", 2);
        numbers.put("три", 3);
        numbers.put("четыре", 4);
        numbers.put("пять", 5);
        numbers.put("шесть", 6);
        numbers.put("семь", 7);
        numbers.put("восемь", 8);
        numbers.put("девять", 9);
        numbers.put("десять", 10);
        HashMap<Integer, String> result = new HashMap<>();
        result.put(0, "ноль");
        result.put(1, "один");
        result.put(2, "два");
        result.put(3, "три");
        result.put(4, "четыре");
        result.put(5, "пять");
        result.put(6, "шесть");
        result.put(7, "семь");
        result.put(8, "восемь");
        result.put(9, "девять");
        result.put(10, "десять");
        result.put(11, "одиннадцать");
        result.put(12, "двенадцать");
        result.put(13, "тринадцать");
        result.put(14, "четырнадцать");
        result.put(15, "пятнадцать");
        result.put(16, "шестнадцать");
        result.put(17, "семнадцать");
        result.put(18, "восемнадцать");
        result.put(19, "девятнадцать");
        result.put(20, "двадцать");
        result.put(30, "тридцать");
        result.put(40, "сорок");
        result.put(50, "пятдесят");
        result.put(60, "шестьдесят");
        result.put(70, "семьдесят");
        result.put(80, "восемьдесят");
        result.put(90, "девяносто");
        result.put(100, "сто");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String str = in.nextLine();
        LinkedList<String> list = new LinkedList<>(Arrays.asList(str.split(" ")));
        list.remove("на");
        String[] array = list.toArray(new String[list.size()]);
        int num1 = numbers.get(array[0]);
        int num2 = numbers.get(array[2]);
        int res = 0;
        if (list.contains("плюс")){
            res = num1 + num2;
        } else if (list.contains("минус")) {
            res = num1 - num2;
        } else {
            res = num1 * num2;
        }
        if ((res < 20 & res >=0) || res % 10 == 0) {
            System.out.println(result.get(res));
        } else if (res < 0) {
            System.out.println("минус " + result.get(-res));
        }
        else {
            System.out.println(result.get(res / 10 * 10) + " " + result.get(res % 10));
        }
    }

}