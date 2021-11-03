package javaMain;

public class MyQueue<T> {

    private Node<T> tail;
    private Node<T> head;


    public MyQueue() {
        tail = null;
        head = null;
    }

    private static class Node<T> {
        private final T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean offer(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        return true;
    }

    public T poll() {
        if (head == null) return null;
        Node<T> poll = head;
        head = head.next;
        return poll.value;
    }

    public T peek() {
        if (head == null) return null;
        return head.value;
    }
}
