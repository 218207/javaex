import java.util.Scanner;

public class task3 {
    public static  void  main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число: ");
        int x = in.nextInt();
        String s = "" + x % 10;
        x = x / 10;
        while (x != 0){
            s += " ,"  + x % 10;
            x = x / 10;

        }
        System.out.println(new StringBuilder(s).reverse());
        in.close();
    }

}
