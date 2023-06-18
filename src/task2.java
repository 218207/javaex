public class task2 {
    public static void main(String[] args){
        String s = "I have 3 cats, 4 dogs, and 1 turtle";
        String[] s1 = s.split("\\D+");
        for (int i = 1; i < s1.length; i ++){
            System.out.println(s1[i]);
        }

    }
}

