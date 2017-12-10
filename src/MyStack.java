import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MyStack {
    class StackNode {
        int data;
        StackNode next = null;

        StackNode(int data) {
            this.data = data;
        }
    }

    StackNode top;

    public void add(int data) {
        StackNode node = new StackNode(data);
        if (top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
    }

    public int peek() {
        if (top == null) {
            throw new NoSuchElementException();
        } else {
            return top.data;
        }
    }

    public int pop() {
        if (top == null) {
            throw new EmptyStackException();
        } else {
            StackNode delete = top;
            top = top.next;
            return delete.data;
        }
    }

    public void print() {
        if (top == null) {
            System.out.println("Nothing");
        } else {
            StackNode current = top;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
    }


    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.add(5);
        stack.add(56);
        stack.add(34);
        stack.print();
        System.out.println(stack.peek());
        stack.add(67);
        System.out.println(stack.pop());
        stack.add(34);
        stack.print();
    }
}
