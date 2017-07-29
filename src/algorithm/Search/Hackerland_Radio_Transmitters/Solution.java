package algorithm.Search.Hackerland_Radio_Transmitters;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for (int x_i = 0; x_i < n; x_i++) {
            x[x_i] = in.nextInt();
        }
        Arrays.sort(x);
        int numOfRadio = 0;
        for (int i = 0; i < n; ) {
            numOfRadio++;
            int targetNum = x[i] + k;
            while (i < n && x[i] <= targetNum) {
                i++;
            }
            targetNum = x[--i] + k;
            while (i < n && x[i] <= targetNum) {
                i++;
            }
        }
        System.out.println(numOfRadio);
    }
}
