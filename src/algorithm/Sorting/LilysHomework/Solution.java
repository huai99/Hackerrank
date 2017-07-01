package algorithm.Sorting.LilysHomework;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long ascendSwap = 0;
        long descendSwap = 0;
        long[] list = new long[n];
        long[] list2 = new long[n];
        Long[] sortedList = new Long[n];
        Map<Long, Integer> positionMap = new HashMap<>();
        Map<Long, Integer> positionMap2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long num = in.nextLong();
            list[i] = num;
            list2[i] = num;
            sortedList[i] = num;
            positionMap.put(num, i);
            positionMap2.put(num, i);
        }

        Arrays.sort(sortedList);
        for (int i = 0; i < n; i++) {
            if (list[i] != sortedList[i]) {
                int position = positionMap.get(sortedList[i]);
                list[position] = list[i];
                positionMap.put(list[i], position);
                ascendSwap++;
            }
        }

        Arrays.sort(sortedList, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return (int) (o2 - o1);
            }
        });

        for (int i = 0; i < n; i++) {
            if (list2[i] != sortedList[i]) {
                int position = positionMap2.get(sortedList[i]);
                list2[position] = list2[i];
                positionMap2.put(list2[i], position);
                descendSwap++;
            }
        }
        System.out.println(Math.min(ascendSwap,descendSwap));
    }
}
