package algorithm.Recursion.Password_Cracker;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    //List to store the words to print
    static ArrayList<String> list;

    //Memoization map
    static HashMap<String, Boolean> memo;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        list = new ArrayList<>();
        memo = new HashMap<>();
        for (int p = 0; p < t; p++) {
            int n = in.nextInt();
            String[] A = new String[n];
            for (int i = 0; i < n; i++) {
                String s = in.next();
                A[i] = s;
            }
            String password = in.next();
            if (verifyIfPassword(A, password)) {
                for (String s1 : list) {
                    System.out.print(s1 + " ");
                }
                System.out.println();
            } else {
                System.out.println("WRONG PASSWORD");
            }

            //Important! : Clear the memo and list
            memo.clear();
            list.clear();
        }
    }

    /*
    This approach is very much like dynamic programming where we test out every possibilities
    and use memoization to increase the efficiency
     */
    public static boolean verifyIfPassword(String[] A, String password) {
        int i = 0;
        if (memo.containsKey(password)) {
            return memo.get(password);
        }
        if (password.equals("") || password.equals(" ") || password.length() == 0) {
            return true;
        }
        for (int k = 0; k < A.length; k++) {
            String a = A[k];
            if (i + a.length() > password.length()) {
                continue;
            }
            String test = password.substring(i, i + a.length());
            ArrayList<String> temp = new ArrayList(list);
            if (test.equals(a)) {
                list.add(a);
                int newLength = i + a.length();
                if (verifyIfPassword(A, password.substring(newLength, password.length()))) {
                    memo.put(password, true);
                    return true;
                } else {
                    list = temp;
                    continue;
                }
            }
        }
        memo.put(password, false);
        return false;
    }
}
