package DataStructures.LinkedLists.GetNodeValue;

public class Solution {
    class Node {
        int data;
        Node next;
    }

    int GetNode(Node head, int n) {
        int length = 0;
        Node current = new Node();
        current.data = head.data;
        current.next = head.next;
        while (current != null) {
            current = current.next;
            length++;
        }
        current = head;
        while (length - n > 1) {
            current = current.next;
            length--;
        }
        return current.data;
    }

}
