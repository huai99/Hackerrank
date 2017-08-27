package algorithm.Recursion.Password_Cracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    static HashMap<String, Boolean> mem;
    static ArrayList<String> list;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        mem = new HashMap<>();
        list = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            String[] str_array = new String[n];
            for (int j = 0; j < n; j++) {
                str_array[j] = in.next();
            }
            String test = in.next();
            if (solve(test, str_array)) {
                for (String word : list) {
                    System.out.print(word + " ");
                }
                System.out.println();
            } else {
                System.out.println("WRONG PASSWORD");
            }

            list.clear();
            mem.clear();
        }
    }

    public static boolean solve(String test, String[] str_array) {
        if (test.equals("") || test.length() == 0) {
            return true;
        }
        if (mem.containsKey(test)) {
            return mem.get(test);
        }
        for (String word : str_array) {
            int length = word.length();
            if (length > test.length()) {
                continue;
            }
            String sub = test.substring(0, length);
            ArrayList<String> temp = new ArrayList(list);
            if (sub.equals(word)) {
                list.add(word);
                String next_sub = test.substring(length, test.length());
                if (solve(next_sub, str_array)) {
                    mem.put(test, true);
                    return true;
                } else {
                    list = temp;
                }
            }
        }
        mem.put(test, false);
        return false;
    }
}
