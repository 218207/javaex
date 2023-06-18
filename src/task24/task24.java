package task24;
public class task24 {
    public static void main(String[] args) {
        SmartForm smartForm = new SmartForm();
        smartForm.input();
        smartForm.submit();
        smartForm.displaySavedPassword();
    }
}
//import java.util.Scanner;
//
//class Form {
//    private String password;
//
//    public void input() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("enter a password: ");
//        password = scanner.nextLine();
//    }
//
//    public void submit() {
//        System.out.println("form was submitted.");
//    }
//
//    public String getPassword() {
//        return password;
//    }
//}
//
//class SmartForm extends Form {
//    private String savedPassword;
//
//    @Override
//    public void input() {
//        super.input();
//        savedPassword = getPassword();
//    }
//
//    public void displaySavedPassword() {
//        System.out.println("saves password: " + savedPassword);
//    }
//}