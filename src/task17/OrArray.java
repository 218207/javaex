package task17;

public class OrArray implements InArray {
    @Override
    public int[] sum(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new IllegalArgumentException("Arrays must be of equal length");
        }
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] | arr2[i];
        }
        return result;
    }
}