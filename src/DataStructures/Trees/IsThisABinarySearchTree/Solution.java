package DataStructures.Trees.IsThisABinarySearchTree;

public class Solution {
    class Node {
        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root) {
        return checkBSTRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkBSTRecursive(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        return root.data < max && root.data > min && checkBSTRecursive(root.left, min, root.data) && checkBSTRecursive(root.right, root.data, max);
    }
}
