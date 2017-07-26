package Week_Of_Code_34.Once_in_a_tram;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String onceInATram(int x) {
        int back = 0;
        int front = -1;
        int backNumber = 0;
        while (back != front) {
            x++;
            front = (int) (x / (Math.pow(10, 5))) + (int) (x / (Math.pow(10, 4))) % 10 + (int) (x / (Math.pow(10, 3))) % 10;
            backNumber = (int) (x % (Math.pow(10, 3)));
            back = (int) (backNumber / (Math.pow(10, 2)))
                    + (int) (backNumber / (Math.pow(10, 1))) % 10
                    + (int) (backNumber / (Math.pow(10, 0))) % 10;
        }
        int frontNumber = (int) (x / (Math.pow(10, 3)));

        return String.valueOf(frontNumber * 1000 + backNumber);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        String result = onceInATram(x);
        System.out.println(result);
    }
}
