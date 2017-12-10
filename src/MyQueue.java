import java.util.EmptyStackException;
import java.util.Queue;

public class MyQueue {

    class QueueNode {
        int data;
        QueueNode next = null;

        QueueNode(int data) {
            this.data = data;
        }
    }

    QueueNode front;
    QueueNode end;

    public void add(int data) {
        QueueNode node = new QueueNode(data);
        if (front == null) {
            front = node;
            end = node;
        } else {
            end.next = node;
            end = node;
        }
    }

    public void dequeue() {
        if (front == null) {
            throw new EmptyStackException();
        }
        front = front.next;
        if (front == null) {
            end = null;
        }
    }

    public void print() {
        if (front == null) {
            System.out.println("Nothing");
        } else {
            QueueNode current = front;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.add(5);
        queue.add(46);
        queue.add(78);
        queue.print();
        queue.dequeue();
        System.out.println();
        queue.add(34);
        queue.add(20);
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.print();
        queue.dequeue();

    }
}
