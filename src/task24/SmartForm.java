package task24;

class SmartForm extends Form {
    private String savedPassword;

    @Override
    public void input() {
        super.input();
        savedPassword = getPassword();
    }

    public void displaySavedPassword() {
        System.out.println("saves password: " + savedPassword);
    }
}