package algorithm.String.Super_Reduced_String;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/*
This solution also quite well thought
Provided by someone else
 */
public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        /*
        Reduce the string until it cannot further be reduced
         */
        while (true) {
            String next = reduce(s);
            if (next.equals(s))
                break;
            s = next;
        }
        System.out.println(s.isEmpty() ? "Empty String" : s);
    }

    private static String reduce(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                i += 2;
                continue;
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
