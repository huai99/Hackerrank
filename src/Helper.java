public class Helper {
    public static int[] countingSort(int[] A) {
        int[] count = new int[201];
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            count[A[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
        }

        for (int i = 0; i < A.length; i++) {
            B[count[A[i]] - 1] = A[i];
            count[A[i]]--;
        }
        return B;
    }
}
