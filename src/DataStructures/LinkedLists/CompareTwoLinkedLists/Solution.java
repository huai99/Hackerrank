package DataStructures.LinkedLists.CompareTwoLinkedLists;

public class Solution {
    class Node {
        int data;
        Node next;
    }

    int CompareLists(Node headA, Node headB) {
        Node currentA = headA;
        Node currentB = headB;
        int lengthA = 0;
        int lengthB = 0;
        while (currentA != null) {
            currentA = currentA.next;
            lengthA++;
        }
        while (currentB != null) {
            currentB = currentB.next;
            lengthB++;
        }

        if (lengthA != lengthB) return 0;
        currentA = headA;
        currentB = headB;
        if (lengthA == lengthB) {
            while (currentA != null & currentB != null) {
                if (currentA.data != currentB.data) {
                    return 0;
                }
                currentA = currentA.next;
                currentB = currentB.next;
            }
            return 1;
        }
        return 0;
    }
}
