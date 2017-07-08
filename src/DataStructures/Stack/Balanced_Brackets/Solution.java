package DataStructures.Stack.Balanced_Brackets;

import java.util.*;


public class Solution {
/*
Difficult part of this question lies at the all the situation you have to factor in
 */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        boolean match = false;
        Stack<Character> stack = new Stack<>();
        String[] array = new String[t];
        for (int a0 = 0; a0 < t; a0++) {
            String s1 = in.next();
            array[a0] = s1;
        }
        in.close();
        for (int i = 0; i < t; i++) {
            String s1 = array[i];
            stack.clear();
            for (char c1 : s1.toCharArray()) {
                //If is left part, then keep adding to the stack
                if (checkLeft(c1)) {
                    stack.push(c1);
                } else {
                    if (stack.isEmpty()) {
                        match = false;
                        break;
                    }
                    char c2 = stack.pop();
                    match = checkMatch(c2, c1);
                    if (!match) {
                        break;
                    }
                }
            }
            if (match && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean checkLeft(char c1) {
        return (c1 == '{' || c1 == '[' || c1 == '(');
    }

    static boolean checkMatch(char s1, char s2) {
        return (s1 == '{' && s2 == '}') || (s1 == '[' && s2 == ']') || (s1 == '(' && s2 == ')');
    }
}