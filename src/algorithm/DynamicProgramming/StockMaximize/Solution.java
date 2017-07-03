package algorithm.DynamicProgramming.StockMaximize;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int price[] = new int[n];
            for (int j = 0; j < n; j++) {
                price[j] = in.nextInt();
            }
            System.out.println(getMaximizedProfit(price));
        }
    }

    public static long getMaximizedProfit(int[] price) {
        long profit = 0;
        long max = 0;
        for (int i = price.length-1; i > -1; i--) {
            if (price[i] > max) {
                max = price[i];
            }
            profit += max - price[i];
        }
        return profit;
    }
}