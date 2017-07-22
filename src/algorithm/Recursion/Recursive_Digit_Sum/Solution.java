package algorithm.Recursion.Recursive_Digit_Sum;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        int k = in.nextInt();
        long digitSum = Long.valueOf(calculateSumOfAllDigit(n)) * k;
        super_digit(String.valueOf(digitSum));
    }

    public static String calculateSumOfAllDigit(String digit) {
        long sum = 0;
        for (int i = 1; i <= digit.length(); i++) {
            int num = Integer.valueOf(digit.substring(i - 1, i));
            sum += num;
        }
        return String.valueOf(sum);
    }

    public static void super_digit(String digit) {
        if (digit.length() <= 1) {
            System.out.println(digit);
        } else {
            super_digit(calculateSumOfAllDigit(digit));
        }
    }
}