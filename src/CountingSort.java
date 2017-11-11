import java.util.Scanner;

public class CountingSort {

    private static int[] countingSort(int max, int[] A) throws Exception {
        int[] count = new int[max];
        for (int i = 0; i < A.length; i++) {
            count[A[i]]++;
        }

        for (int i = 1; i < max; i++) {
            count[i] += count[i - 1];
        }

        int[] B = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            B[count[A[i]] - 1] = A[i];
            count[A[i]]--;
        }
        return B;
    }

    private static String sortString(String str) {
        int n = str.length();
        int[] A = new int[n];
        for (int i = 0; i < str.length(); i++) {
            A[i] = (int) str.charAt(i);
        }
        try {
            A = countingSort(256, A);
        } catch (Exception e) {
            e.printStackTrace();
        }
        char[] B = new char[n];
        for (int i = 0; i < A.length; i++) {
            B[i] = (char) A[i];
        }
        return String.valueOf(B, 0, B.length);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        s = sortString(s);
        System.out.println(s);
    }
}
