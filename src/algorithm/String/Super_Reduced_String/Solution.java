package algorithm.String.Super_Reduced_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] chars = s.toCharArray();
        int prevIndex = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[prevIndex] == chars[i]) {
                //Remove the character by replacing it with '0'
                chars[prevIndex] = '0';
                chars[i] = '0';
                int k = prevIndex;
                //Go back and find the previous character which is not '0'
                while (k >= 0) {
                    if (chars[k] != '0') {
                        break;
                    }
                    k--;
                }
                if (k >= 0) {
                    prevIndex = k;
                }
                continue;
            }
            prevIndex = i;
        }
        StringBuilder newS = new StringBuilder("");
        for (char c : chars) {
            if (c != '0') {
                newS.append(c);
            }
        }
        if (newS.toString().equals("")) {
            System.out.println("Empty String");
        } else {
            System.out.println(newS.toString());
        }
    }
}
