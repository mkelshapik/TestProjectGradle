package javaMain;


import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyHashSet<E> implements Set<E> {

    Map<E, E> internalMap = new MyHashMap<>();

    @Override
    public int size() {
        return internalMap.size();
    }

    @Override
    public boolean isEmpty() {
        return internalMap.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return internalMap.containsKey(o);
    }

    @Override
    public boolean add(E e) {
        if (contains(e)) {
            return false;
        }
        internalMap.put(e, e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (internalMap.containsKey(o)) {
            internalMap.remove(o);
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        internalMap = new MyHashMap<>(internalMap.size());
    }

    //////////// NotImplemented ////////////

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public Iterator<E> iterator() {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public Object[] toArray() {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new IndexOutOfBoundsException();
    }
}