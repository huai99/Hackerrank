package DataStructures.Stack.Equal_Stacks;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int length1 = 0, length2 = 0, length3 = 0;
        int h1[] = new int[n1];
        for (int h1_i = 0; h1_i < n1; h1_i++) {
            int num = in.nextInt();
            h1[h1_i] = num;
            length1 += num;

        }
        int h2[] = new int[n2];
        for (int h2_i = 0; h2_i < n2; h2_i++) {
            int num = in.nextInt();
            h2[h2_i] = num;
            length2 += num;
        }
        int h3[] = new int[n3];
        for (int h3_i = 0; h3_i < n3; h3_i++) {
            int num = in.nextInt();
            h3[h3_i] = num;
            length3 += num;
        }
        Stack<Integer> stack1 = new Stack<>();
        for (int i = n1 - 1; i > -1; i--) {
            stack1.add(h1[i]);
        }

        Stack<Integer> stack2 = new Stack<>();
        for (int i = n2 - 1; i > -1; i--) {
            stack2.add(h2[i]);
        }

        Stack<Integer> stack3 = new Stack<>();
        for (int i = n3 - 1; i > -1; i--) {
            stack3.add(h3[i]);
        }

        //Keep on decreasing the height of each stack until three of them are the same
        while ((length1 != length2) || (length2 != length3) || (length1 != length3)) {
            int min = Integer.MAX_VALUE;
            if (length1 < min) {
                min = length1;
            }
            if (length2 < min) {
                min = length2;
            }
            if (length3 < min) {
                min = length3;
            }
            // If the stack length is the minimum, do nothing
            if (length1 != min) {
                int deleteNum = stack1.pop();
                length1 -= deleteNum;
            }
            if (length2 != min) {
                int deleteNum = stack2.pop();
                length2 -= deleteNum;
            }
            if (length3 != min) {
                int deleteNum = stack3.pop();
                length3 -= deleteNum;
            }
        }
        System.out.println(length1);
    }
}
