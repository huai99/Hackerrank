package DataStructures.Stack.Game_Of_Two_Stacks;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedInputStream bf = new BufferedInputStream(System.in);

        BufferedReader r = new BufferedReader(
                new InputStreamReader(bf, StandardCharsets.UTF_8));

        int g = Integer.parseInt(r.readLine());

        for (int a0 = 0; a0 < g; a0++) {
            String[] temp = r.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            int x = Integer.parseInt(temp[2]);
            String[] a_string = r.readLine().split(" ");
            int[] a_array = new int[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a_array[a_i] = Integer.parseInt(a_string[a_i]);
            }
            String[] b_string = r.readLine().split(" ");
            int[] b_array = new int[m];

            for (int b_i = 0; b_i < m; b_i++) {
                b_array[b_i] = Integer.parseInt(b_string[b_i]);
            }

            int i = 0, j = 0, sum = 0, count = 0;
            /*
            The intuition is the total number must be p*A + q*B, and we want to find the greatest
            number of p+q
             */

            /*
            We first add all the number from one stacks, and slowly decrease one and add from another stack,
            through this iterative approach, we will find the greatest value of p+q, after the iteration ends
             */
            while (i < n && sum + a_array[i] <= x) {
                sum += a_array[i];
                i++;
            }
            count = i;
            while (j < m && i >= 0) {
                sum += b_array[j];
                j++;
                while (sum > x && i > 0) {
                    sum -= a_array[i - 1];
                    i--;
                }
                if (sum <= x && i + j > count) {
                    count = i + j;
                }
            }

            System.out.println(count);
        }
    }
}
