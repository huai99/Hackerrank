import java.util.Scanner;

public class Quicksort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        int[] A = new int[g];
        for (int i = 0; i < g; i++) {
            A[i] = in.nextInt();
        }
        quicksort(0, A.length - 1, A);
        for (int num : A) {
            System.out.print(num + " ");
        }
    }

    public static void quicksort(int head, int tail, int[] a) {
        if (tail - head < 1) {
            return;
        }
        int i = 0;
        int h = 0;
        while (i < tail - head) {
            if (a[tail] > a[head + i]) {
                swap(head + i, head + h, a);
                h++;
            }
            i++;
        }
        swap(tail, head + h, a);
        quicksort(head, head + h - 1, a);
        quicksort(head + h + 1, tail, a);
    }

    static void swap(int a, int b, int[] A) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
