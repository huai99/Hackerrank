package algorithm.Search.MinimumLoss;

import java.util.Scanner;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] price = new long[n];
        for (int i = 0; i < n; i++) {
            price[i] = in.nextLong();
        }
        long best = Long.MAX_VALUE;
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = n - 1; i >= 0; i--) {
            Long smaller = treeSet.floor(price[i]);
            if (smaller != null) {
                long diff = price[i] - smaller;
                if (diff >= 0) {
                    best = Math.min(diff, best);
                }
            }
            treeSet.add(price[i]);
        }
        System.out.print(best);
    }
}
