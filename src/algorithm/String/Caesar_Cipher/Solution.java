package algorithm.String.Caesar_Cipher;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int flip = in.nextInt();
        StringBuilder sb = new StringBuilder("");
        for (char c : s.toCharArray()) {
            int ascii = (int) c;
            if ((ascii >= 65 && ascii <= 90)||(ascii >= 97 && ascii <= 122)) {
                int chgAscii = ascii + flip;
                String convert;
                if (isLowerCase((char) ascii)) {
                    while (chgAscii > 122) {
                        chgAscii = chgAscii - 122 + 96;
                    }
                } else {
                    while (chgAscii > 90) {
                        chgAscii = chgAscii - 90 + 64;
                    }
                }
                convert = String.valueOf((char) chgAscii);
                sb.append(convert);
            } else {
                sb.append(String.valueOf(c));
            }
        }
        System.out.println(sb.toString());
    }

    static boolean isLowerCase(char c) {
        return (c >= 97 && c <= 122);
    }
}
