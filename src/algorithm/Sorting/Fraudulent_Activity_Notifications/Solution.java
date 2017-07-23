package algorithm.Sorting.Fraudulent_Activity_Notifications;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] expenses = new int[n];
        for (int i = 0; i < n; i++) {
            expenses[i] = in.nextInt();
        }
        System.out.println(fraudulentNotifications(expenses, d));

    }

    public static long fraudulentNotifications(int[] expenses, int d) {
        int[] countSort = new int[201];
        int i = 0;
        long notification = 0;
        for (; i < d; i++) {
            countSort[expenses[i]]++;
        }
        i =0;
        int j = d;
        while (j < expenses.length) {
            double median = getMedian(countSort, d);
            if (expenses[j] >= 2 * median) {
                notification++;
            }
            countSort[expenses[i]]--;
            countSort[expenses[j]]++;
            i++;
            j++;
        }
        return notification;
    }

    public static double getMedian(int[] countingSort, int d) {
        int medianIndex = (d % 2) != 0 ? (d + 1) / 2 : d / 2;
        int count = 0;
        int i = 0;
        for (; count < medianIndex; i++) {
            count = count + countingSort[i];
        }
        int j = i;
        i = i-1;
        if (count > medianIndex || d % 2 != 0) {
            return i;
        }
        for (; countingSort[j] == 0; j++) ;
        return (i + j) / 2d;

    }
}


