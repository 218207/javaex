package task17;

import java.util.Arrays;

public class ArrayOperationRunner {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};

        InArray arraySum = new ArraySum();
        int[] sumResult = arraySum.sum(arr1, arr2);
        System.out.println("Array Sum Result: " + Arrays.toString(sumResult));

        InArray orArray = new OrArray();
        int[] orResult = orArray.sum(arr1, arr2);
        System.out.println("Or Array Result: " + Arrays.toString(orResult));
    }
}