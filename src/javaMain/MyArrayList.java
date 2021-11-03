package javaMain;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private final int INITIAL_CAPACITY = 10;
    private int size = 0;
    private int capacity = INITIAL_CAPACITY;
    T[] t;

    public MyArrayList() {
        t = (T[]) new Object[INITIAL_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Неправильно вказаний індекс");
        } else {
            t = (T[]) new Object[capacity];
            this.capacity = capacity;
        }
    }

    private void increaseCapacity() {
        T[] temp = t;
        t = (T[]) new Object[temp.length + INITIAL_CAPACITY];
        System.arraycopy(temp, 0, t, 0, temp.length);
        capacity = t.length;
    }

    @Override
    public boolean add(T o) {
        if (size == capacity) {
            increaseCapacity();
        }
        t[size++] = o;
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Неправильно вказаний індекс");
        }
        if (size == capacity) {
            increaseCapacity();
        }
        System.arraycopy(t, index, t, index + 1, size - index);
        t[index] = element;
        size++;
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0) throw new IllegalArgumentException("Неправильно вказаний індекс");
        T[] temp = t;
        t = (T[]) new Object[size - 1];
        if (index == t.length - 1) {
            System.arraycopy(temp, 0, t, 0, t.length);
        } else if (index == 0) {
            System.arraycopy(temp, 1, t, 0, t.length);
        } else {
            System.arraycopy(temp, 0, t, 0, index);
            System.arraycopy(temp, index + 1, t, index, size - (index + 1));
        }
        capacity = t.length;
        size--;
        return temp[index];
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
    public T get(int index) {
        if (index > size || index < 0) throw new IllegalArgumentException("Неправильно вказаний індекс");
        return t[index];
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (t[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        t = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public T set(int index, T element) {
        if (index >= size || index < 0) throw new IllegalArgumentException("Неправильно вказаний індекс");
        T oldValue = t[index];
        t[index] = element;
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (t[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
        return t;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (t[i].equals(o)) {

                T[] temp = t;
                t = (T[]) new Object[size - 1];
                if (i == size - 1) {
                    System.arraycopy(temp, 0, t, 0, t.length);
                } else if (i == 0) {
                    System.arraycopy(temp, 1, t, 0, t.length);
                } else {
                    System.arraycopy(temp, 0, t, 0, i);
                    System.arraycopy(temp, i + 1, t, i, size - (i + 1));
                }
                size--;
                capacity = t.length;
                return true;
            }
        }
        return false;
    }

    private class ArIterator implements Iterator<T> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            return t[index++];
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new ArIterator();
    }


    //////////// Not Implemented ////////////

    @Override
    public boolean addAll(Collection c) {
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

    @Override
    public boolean retainAll(Collection c) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new IndexOutOfBoundsException();
    }

}
