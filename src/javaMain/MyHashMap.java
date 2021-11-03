package javaMain;

import java.util.*;


public class MyHashMap<K, V> implements Map<K, V> {

    private MyLinkedList<Node<K, V>>[] table;
    private int size;
    private static final int INITIAL_CAPACITY = 16;


    public MyHashMap() {
        init(INITIAL_CAPACITY);
        size = 0;
    }

    public MyHashMap(int capacity) {
        init(capacity);
        size = 0;
    }

    private void init(int capacity) {
        table = new MyLinkedList[capacity];
        size = 0;
        for (int i = 0; i < table.length; i++) {
            table[i] = new MyLinkedList<Node<K, V>>();
        }
    }

    private void checkAndIncreaseSize() {
        float threshold = 0.75f;
        if (size >= table.length * threshold) {
            MyLinkedList<Node<K, V>>[] oldTable = table;
            init(table.length * 2);
            for (MyLinkedList<Node<K, V>> list : oldTable) {
                for (int i = 0; i < list.size(); i++) {
                    //if (list.get(i) != null) {
                    put(list.get(i).getKey(), list.get(i).getValue());
                }
            }
        }
    }

    public int tableIndex(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    @Override
    public V put(K key, V value) {
        checkAndIncreaseSize();
//        if (key == null) {
//
//            return null;
//        } else {
        Node<K, V> newNode = new Node<>(key, value);
        MyLinkedList<Node<K, V>> listOfNodes = table[tableIndex(key)];
        final int index = listOfNodes.indexOf(newNode);
        if (index == -1) {
            listOfNodes.add(newNode);
            size++;
        } else {
            listOfNodes.set(index, newNode);
        }
        return value;
//        }
    }

    @Override
    public V get(Object key) {
        MyLinkedList<Node<K, V>> listOfNodes = table[tableIndex((K) key)];
        Iterator<Node<K, V>> iterator = listOfNodes.iterator();
        while (iterator.hasNext()) {
            Node<K, V> node = iterator.next();
            if (Objects.equals(node.key, key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        MyLinkedList<Node<K, V>> listOfNodes = table[tableIndex((K) key)];
        Iterator<Node<K, V>> iterator = listOfNodes.iterator();
        while (iterator.hasNext()) {
            Node<K, V> node = iterator.next();
            if (Objects.equals(node.key, key)) {
                V saveVal = node.getValue();
                listOfNodes.remove(node);
                size--;
                return saveVal;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        MyLinkedList<Node<K, V>> listOfNodes = table[tableIndex((K) key)];
        Iterator<Node<K, V>> iterator = listOfNodes.iterator();
        while (iterator.hasNext()) {
            Node<K, V> node = iterator.next();
            if (Objects.equals(node.key, key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (MyLinkedList<Node<K, V>> listOfNodes : table) {
            Iterator<Node<K, V>> iterator = listOfNodes.iterator();
            while (iterator.hasNext()) {
                Node<K, V> node = iterator.next();
                if (Objects.equals(node.value, value)) {
                    return true;
                }
            }
        }
        return false;
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
        init(table.length);
        size = 0;
    }


    //////////// NotImplemented ////////////

    @Override
    public Set<K> keySet() {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public Collection<V> values() {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new IndexOutOfBoundsException();
    }

    public static class Node<K, V> {

        private final K key;
        private final V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }


        @Override
        public boolean equals(Object o) {
//            if (o == null || getClass() != o.getClass()) return false;
//            if (this == o) return true;
            Node<K, V> node = (Node<K, V>) o;
            return Objects.equals(node.key, key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }
}
