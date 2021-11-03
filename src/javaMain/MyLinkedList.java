package javaMain;


import java.util.*;

public class MyLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    private class Node<E> {
        private E val;
        private Node<E> next;
        private Node<E> prev;

        private Node(E val) {
            this.val = val;
        }
    }

    @Override
    public boolean add(E o) {
        Node<E> newNode = new Node<>(o);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException("Індекс вказаний не вірно!");
        Node<E> newNode = new Node<E>(element);
        if (head == null) {
            head = tail = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next.prev = newNode;
            newNode.prev = current;
            current.next = newNode;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Індекс вказаний не вірно!");
        Node<E> temp;
        if (size == 1) {
            temp = head;
            clear();
        } else if (index == size - 1) {
            temp = tail;
            tail = tail.prev;
            tail.next = null;
        } else if (index == 0) {
            temp = head;
            head = head.next;
            head.prev = null;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            temp = current;
            current.next.prev = current.prev;
            current.prev.next = current.next;
        }
        size--;
        return temp.val;
    }

    @Override
    public boolean remove(Object o) {
        for (Node<E> current = head; current != null; current = current.next) {
            if (Objects.equals(current.val, o)) {
                if (current == head) {
                    head = head.next;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.next.prev = current.prev;
                    current.prev.next = current.next;
                }
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> current = head;
        while (current != null) {
            if (Objects.equals(current.val, o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public E set(int index, E element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Індекс вказаний не вірно!");
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.val = (E) element;
        return current.val;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (Objects.equals(current.val, o)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Індекс вказаний не вірно!");
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        final Node<E>[] currentNode = new Node[]{head};
        return new Iterator<E>() {

            @Override
            public boolean hasNext() {
                return currentNode[0] != null;
            }

            @Override
            public E next() {
                Node<E> current = currentNode[0];
                currentNode[0] = currentNode[0].next;
                return current.val;
            }

            @Override
            public void remove() {
                if (currentNode[0] == null) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    Node<E> current = currentNode[0].prev;
                    if (current == head) {
                        head = head.next;
//                    } else if (current == tail) {
//                        tail = tail.prev;
//                        tail.next = null;
                    } else {
                        current.next.prev = current.prev;
                        current.prev.next = current.next;
                    }
                }
                size--;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        Node<E> current = head;
        int inx = 0;
        while (current != null) {
            result[inx++] = current.val;
            current = current.next;
        }
        return result;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
        return true;
    }


    //////////// NotImplemented ////////////

    @Override
    public Object[] toArray(Object[] a) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ListIterator listIterator() {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new IndexOutOfBoundsException();
    }
}
