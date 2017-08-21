package DataStructures.Trees.Tree_Huffman_Decoding;

import java.util.ArrayList;

public class Solution {

    class Node {
        public int frequency;
        public char data;
        public Node left, right;
    }

    void decode(String S, Node root) {
        int trackingIndex = 0;
        Node current = root;
        ArrayList<Character> list = new ArrayList<>();
        while (trackingIndex < S.length()) {
            if (S.charAt(trackingIndex) == '0') {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current.data=='\0') {
                trackingIndex++;
            } else {
                list.add(current.data);
                current = root;
                trackingIndex++;
            }
        }
        for (char k : list) {
            System.out.print(k);
        }
    }

}
