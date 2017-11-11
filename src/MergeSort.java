import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        mergeSort(0, n - 1, arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int head, int tail, int[] array) {
        if (head == tail) return;

        int middle = (head + tail) / 2;
        mergeSort(head, middle, array);
        mergeSort(middle + 1, tail, array);
        merge(head, middle, tail, array);
    }


    public static void merge(int head, int middle, int tail, int[] array) {
        /*if (tail - head + 1 == 2) {
            int temp = array[head];
            if (array[head] > array[tail]) {
                array[head] = array[tail];
                array[tail] = temp;
            }
            return;
        }*/

        int left_length = (middle - head) + 1;
        int right_length = tail - middle;
        int current = head;

        int[] left = new int[left_length];
        for (int i = 0; i < left_length; i++) {
            left[i] = array[current];
            current++;
        }

        int[] right = new int[right_length];
        current = middle + 1;
        for (int i = 0; i < right_length; i++) {
            right[i] = array[current];
            current++;
        }

        int[] temp = new int[left_length + right_length];
        int p = 0, q = 0, k = 0;
        while (p < left_length && q < right_length) {
            if (left[p] < right[q]) {
                temp[k] = left[p];
                k++;
                p++;
            } else {
                temp[k] = right[q];
                q++;
                k++;
            }
        }

        if (p >= left_length) {
            for (int i = q; i < right_length; i++) {
                temp[k] = right[i];
                k++;
            }
        } else {
            for (int i = p; i < left_length; i++) {
                temp[k] = left[i];
                k++;
            }
        }

        int totalLength = tail - head + 1;

        for (int i = 0; i < totalLength; i++) {
            array[head + i] = temp[i];
        }
    }
}
