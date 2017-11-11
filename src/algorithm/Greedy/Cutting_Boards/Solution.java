package algorithm.Greedy.Cutting_Boards;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int row = in.nextInt();
            int column = in.nextInt();

            long[] rowCost = new long[row - 1];
            for (int j = 0; j < rowCost.length; j++) {
                rowCost[j] = in.nextInt();
            }

            long[] columnCost = new long[column - 1];
            for (int j = 0; j < columnCost.length; j++) {
                columnCost[j] = in.nextInt();
            }
            Arrays.sort(rowCost);
            Arrays.sort(columnCost);
            rowCost = reverse(rowCost);
            columnCost = reverse(columnCost);
            System.out.println(solve(row, column, rowCost, columnCost));
        }
    }

    public static long solve(int row, int column, long[] rowCost, long[] columnCost) {
        int pointX = 0, pointY = 0;
        long segmentX = 1, segmentY = 1;
        long cost = 0;
        while (pointX < rowCost.length && pointY < columnCost.length) {
            long scenario1 = rowCost[pointX] * segmentY + columnCost[pointY] * (segmentX + 1);
            long scenario2 = columnCost[pointY] * segmentX + rowCost[pointX] * (segmentY + 1);
            if (scenario1 < scenario2) {
                cost += rowCost[pointX] * segmentY;
                pointX++;
                segmentX++;
            } else {
                cost += columnCost[pointY] * segmentX;
                pointY++;
                segmentY++;
            }
        }
        if (pointX >= rowCost.length) {
            while (pointY < columnCost.length) {
                cost += columnCost[pointY] * segmentX;
                pointY++;
                segmentY++;
            }
        } else {
            while (pointX < rowCost.length) {
                cost += rowCost[pointX] * segmentY;
                pointX++;
                segmentX++;
            }
        }
        return cost % (1000000007);
    }

    private static long[] reverse(long[] arr) {
        long[] newarr = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[arr.length - 1 - i];
        }
        return newarr;
    }
}
