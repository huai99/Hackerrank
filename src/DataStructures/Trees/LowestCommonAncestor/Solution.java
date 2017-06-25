package DataStructures.Trees.LowestCommonAncestor;

public class Solution {

    class Node {
        Node left;
        Node right;
        int data;
    }

    /*
    The idea is the value v1,v2 must be in between of the parent node value
     */
    static Node lca(Node root, int v1, int v2) {
        int smaller = Math.min(v1, v2);
        int bigger = Math.max(v1, v2);
        if (root.data > bigger) {
            return lca(root.left, v1, v2);
        } else if (root.data < smaller) {
            return lca(root.right, v1, v2);
        }

        return root;
    }

}
