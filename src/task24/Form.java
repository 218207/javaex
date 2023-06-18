package task24;

import java.util.Scanner;

class Form {
    private String password;

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a password: ");
        password = scanner.nextLine();
    }

    public void submit() {
        System.out.println("form was submitted.");
    }

    public String getPassword() {
        return password;
    }
}
