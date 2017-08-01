package DataStructures.Heap.QHeap1;

import java.util.Scanner;

public class Solution {
    static int[] v;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        v = new int[10];
        int n = 0;
        for (int i = 0; i < q; i++) {
            int command = in.nextInt();
            if (command == 1) {
                insert(in.nextInt(), n);
                n++;
            } else if (command == 2) {
                delete(in.nextInt(), n);
                n--;
            } else if (command == 3) {
                printMin(v);
            }
        }
    }

    public static void siftdown(int i, int n) {
        while ((2 * i) + 1 < n) {
            int smallerChildIndex = 0;
            if (2 * i + 2 >= n) {
                smallerChildIndex = 2 * i + 1;
            } else {
                smallerChildIndex = (v[2 * i + 1] < v[2 * i + 2]) ? (2 * i + 1) : (2 * i + 2);
            }
            if (v[smallerChildIndex] < v[i]) {
                swap(smallerChildIndex, i);
                i = smallerChildIndex;
            } else {
                break;
            }
        }
    }

    public static void heapify(int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftdown(i, n);
        }
    }

    public static void insert(int newNumber, int n) {
        n++;
        if (n >= v.length) {
            v = doubleSize();
            int length = v.length;
        }
        v[n - 1] = newNumber;
        heapify(n);
    }

    public static void delete(int target, int n) {
        int targetIndex = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] == target) targetIndex = i;
        }
        swap(targetIndex, n - 1);
        n--;
        heapify(n);
    }

    public static void printMin(int[] v) {
        System.out.println(v[0]);
    }

    public static void swap(int a1, int a2) {
        int temp = v[a1];
        v[a1] = v[a2];
        v[a2] = temp;
    }

    public static int[] doubleSize() {
        int n = v.length;
        int[] A = new int[2 * n];
        for (int i = 0; i < n; i++) {
            A[i] = v[i];
        }
        return A;
    }
}
