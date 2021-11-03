package javaMain;

import java.util.Arrays;
import java.util.Comparator;

public class MyHeap<T> {
    private int capacity = 10;
    private int size = 0;

    private Comparator<T> comparator;
    private T[] items = (T[]) new Object[capacity];

    public MyHeap(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

//    private boolean hasParent(int index) {
//        return getParentIndex(index) >= 0;
//    }

    private T leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private T rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private T parent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo) {
        T temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public T peek() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        return items[0];
    }

    public T poll() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        T item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(T element) {
        ensureExtraCapacity();
        items[size] = element;
        size++;
        heapifyUp();
    }

    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            //if (hasRightChild(index) && rightChild(index) < leftChild(index))
            if (hasRightChild(index) && comparator.compare(rightChild(index), leftChild(index)) < 0) {
                smallerChildIndex = getRightChildIndex(index);
            }

            //if (items[index] < items[smallerChildIndex]) {
            if (comparator.compare(items[index], items[smallerChildIndex]) < 0) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    public void heapifyUp() {
        int index = size - 1;
        //parent(index) > items[index])
        while (/*hasParent(index) && */comparator.compare(parent(index), items[index]) > 0) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public int size() {
        return size;
    }
}
