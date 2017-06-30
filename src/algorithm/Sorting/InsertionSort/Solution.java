package algorithm.Sorting.InsertionSort;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = in.nextInt();
        }
        int targetNum = list[n - 1];
        int i = 0;
        for (i = n - 2; i >= 0; i--) {
            if (list[i] > targetNum) {
                list[i + 1] = list[i];
                print(list);
            } else {
                list[i + 1] = targetNum;
                print(list);
                break;
            }
        }
        if (i == -1) {
            list[0] = targetNum;
            print(list);
        }
    }

    public static void print(int[] list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
