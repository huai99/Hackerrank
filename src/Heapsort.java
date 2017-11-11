import java.util.Scanner;

public class Heapsort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] input = new int[]{10, 20, 60, 12, 45, 56, 34, 23, 45, 67, 78, 97, 45, 23, 34, -12};
        printTree(input);
//        heapify(input, input.length - 1);
        System.out.println();
        sort(input);
        for (int num : input) {
            System.out.print(num + " ");
        }
//        printTree(input);
    }

    private static void printTree(int[] arr) {
        int track = 1;
        int k = 0;
        int sum = track;
        while (true) {
            while (k < sum) {
                System.out.print(arr[k] + " ");
                k++;
            }
            System.out.println();
            track *= 2;
            sum += track;
            if (sum > arr.length) {
                sum = arr.length;
            }
            if (k >= arr.length) break;
        }
    }

    public static void sort(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            heapify(a, i);
            swap(a, 0, i);
        }
    }

    public static void siftDown(int[] a, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int child = -1;
        if (left <= n && right <= n) {
            if (a[left] > a[right]) {
                child = left;
            } else {
                child = right;
            }
        } else {
            if (left > n) {
                return;
            } else {
                child = left;
            }
        }
        if (a[child] > a[i]) {
            swap(a, child, i);
            siftDown(a, child, n);
        }
    }

    private static void heapify(int[] a, int n) {
        int originalN = n;
        if (n % 2 == 0) {
            n = (n - 2) / 2;
        } else {
            n = (n - 1) / 2;
        }
        int track = n;
        while (track >= 0) {
            siftDown(a, track, originalN);
            track--;
        }

       /* int i = 0;
        while (i < a.length) {
            siftDown
           (a, i, a.length - 1);
            i++;
        }*/
    }

    private static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
