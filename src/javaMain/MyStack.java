package javaMain;

public class MyStack<T> {

    private Node<T> head;

    public MyStack() {
        this.head = null;
    }

    static class Node<T> {
        private final T val;
        private Node<T> prev;

        public Node(T val) {
            this.val = val;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(T val) {
        Node<T> newNode = new Node<>(val);
        if (head != null) {
            newNode.prev = head;
        }
        head = newNode;
    }

    public T pop() {
        if (head == null) return null;
        Node<T> pop = head;
        head = head.prev;
        return pop.val;
    }

    public T peek() {
        if (head == null) return null;
        return head.val;
    }
}
