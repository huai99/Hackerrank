package algorithm.Recursion.Stone_Division;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    static HashMap<Long, Long> memo;

    /*
    The main idea in the end is to count the nodes of the tree excluding the very base level
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        memo = new HashMap<>();
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            long n = in.nextLong();
            int s = in.nextInt();
            long[] arr = new long[s];
            for (int j = 0; j < s; j++) {
                arr[j] = in.nextLong();
            }
            Arrays.sort(arr);
            System.out.println(solve_recur(n, arr, 1));

            // Clear the memory is an extremely important step
            memo.clear();
        }
    }

    static long solve_recur(long n, long[] arr, long siblingNum) {
        if (memo.containsKey(n)) {
            return memo.get(n) * siblingNum + siblingNum;
        }

        if (n <= arr[0]) {
            return 0;
        }
        long max = Long.MIN_VALUE;
        long local = 0;
        for (long nextPileSize : arr) {
            if (n % nextPileSize == 0 && n > nextPileSize) {
                long nextSiblingNum = n / nextPileSize;
                long kidsNum = solve_recur(nextPileSize, arr, nextSiblingNum);
                //Memo is keeping what is the maximum kid one node can spawn
                if (!memo.containsKey(n)) {
                    memo.put(n, kidsNum);
                } else {
                    if (kidsNum > memo.get(n)) {
                        memo.put(n, kidsNum);
                    }
                }
                local = siblingNum + kidsNum * siblingNum;
                max = Math.max(max, local);
            }
        }
        return max;
    }

}