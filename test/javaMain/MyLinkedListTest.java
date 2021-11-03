package javaMain;

import javaMain.MyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();


    @Test
    void isEmpty() {
        // check is the list really empty
        assertTrue(myLinkedList.isEmpty(), "List isn`t empty!");

        myLinkedList.add(0);
        assertFalse(myLinkedList.isEmpty());
    }

    @Test
    void get() {
        // catch throw for empty list
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.get(10));
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.get(-10));
        // check last and first el in list
        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);

        assertEquals(4, myLinkedList.indexOf(4));
        assertEquals(0, myLinkedList.get(0));
    }

    @Test
    void size() {
        // check size for empty list
        assertEquals(0, myLinkedList.size(), "Size isn`t equal 0");
    }

    @Test
    void add() {
        // adds some element and check size(), isEmpty(), value;
        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(2);

        assertFalse(myLinkedList.isEmpty(), "List is Empty!");
        assertEquals(3, myLinkedList.size(), "Size of List isn`t 3!");
        assertEquals(0, myLinkedList.get(0), "First element isn`t 0!");
        assertEquals(1, myLinkedList.get(1), "Second element isn`t 1!");
        assertEquals(2, myLinkedList.get(2), "Third element isn`t 2!");
    }

    @Test
    void testAdd() {
        // check the right work of add() with index
        myLinkedList.add(0, 0);
        myLinkedList.add(1, 1);
        myLinkedList.add(2, 2);
        myLinkedList.add(3, 3);
        myLinkedList.add(4, 4);
        myLinkedList.add(5, 5);
        myLinkedList.add(3, 33);
        myLinkedList.add(0, 11);

        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.add(10, 15));
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.add(-10, 15));
        assertEquals(33, myLinkedList.get(4));
        assertEquals(11, myLinkedList.get(0));
        assertEquals(5, myLinkedList.get(7));
    }

    @Test
    void remove() {
        // check remove(index) and value that this fun return
        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);

        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.remove(10));
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.remove(-10));


        assertFalse(myLinkedList.isEmpty());
        assertEquals(6, myLinkedList.size());

        assertEquals(2, myLinkedList.remove(2));
        assertEquals(5, myLinkedList.remove(4));
        assertEquals(4, myLinkedList.size());
        assertEquals(0, myLinkedList.remove(0));
        assertEquals(1, myLinkedList.remove(0));
        assertEquals(3, myLinkedList.remove(0));
        assertEquals(4, myLinkedList.remove(0));
    }

    @Test
    void testRemove() {
        // check fun remove(obj) from same pos(0, size and other)
        // and check case when fun return false
        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);

        assertTrue(myLinkedList.remove((Object) 0));
        assertEquals(1, myLinkedList.get(0));
        assertTrue(myLinkedList.remove((Object) 5));
        assertTrue(myLinkedList.remove((Object) 3));
        assertFalse(myLinkedList.remove((Object) 10));
        assertEquals(3, myLinkedList.size());
    }

    @Test
    void contains() {
        // check if our list contains value 0, 5, 10
        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);

        assertTrue(myLinkedList.contains(0));
        assertTrue(myLinkedList.contains(5));
        assertFalse(myLinkedList.contains(10));
    }

    @Test
    void set() {
        // check if fun set work right
        // set with first, last, and anyone inside index
        myLinkedList.add(0);
        myLinkedList.add(0);
        myLinkedList.add(0);
        myLinkedList.add(0);
        myLinkedList.add(0);

        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.set(10, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.set(-10, 10));


        assertEquals(1, myLinkedList.set(1, 1));
        assertEquals(2, myLinkedList.set(2, 2));
        assertEquals(3, myLinkedList.set(3, 3));
        assertEquals(4, myLinkedList.set(4, 4));

        assertEquals(5, myLinkedList.size());
        assertFalse(myLinkedList.isEmpty());
        assertEquals(4, myLinkedList.get(4));
    }

    @Test
    void indexOf() {
        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(0);
        myLinkedList.add(2);
        myLinkedList.add(2);

        assertEquals(0, myLinkedList.indexOf(0));
        assertEquals(1, myLinkedList.indexOf(1));
        assertEquals(3, myLinkedList.indexOf(2));

        //now remove some el and check index
        myLinkedList.remove(2);
        myLinkedList.remove(3);
        assertEquals(2, myLinkedList.get(2));
    }

    @Test
    void clear() {
        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(0);
        myLinkedList.add(2);
        myLinkedList.add(2);

        myLinkedList.clear();

        assertTrue(myLinkedList.isEmpty());
        assertEquals(0, myLinkedList.size());
    }

    @Test
    void iterator() {
        for (int i = 0; i <= 5; i++) {
            myLinkedList.add(i);
        }

        Iterator<Integer> iterator = myLinkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
            System.out.println("Size = " + myLinkedList.size());
        }
    }

    @Test
    void toArray() {
        for (int i = 0; i <= 20; i++) {
            myLinkedList.add(i);
        }
        Object[] objects = myLinkedList.toArray();
        for (Object o : objects) {
            System.out.println(o);
        }
    }

    @Test
    void containsAll() {
        MyLinkedList<Integer> integers = new MyLinkedList<>();
        for (int i = 0; i < 20; i++) {
            integers.add(i);
            myLinkedList.add(i);
        }
        assertTrue(myLinkedList.containsAll(integers));
        myLinkedList.add(21);
        assertTrue(myLinkedList.containsAll(integers));
        integers.add(34);
        assertFalse(myLinkedList.containsAll(integers));
    }

    @Test
    void addAll() {
        for (int i = 0; i < 10; i++) {
            myLinkedList.add(i);
        }
        MyLinkedList<Integer> integers = new MyLinkedList<>();
        integers.addAll(myLinkedList);
        int c = 0;
        for (Integer i : integers) {
            assertEquals(i, myLinkedList.get(c++));
        }
    }

    @Test
    void checkRemoveInIteratorIfDeletedElementIsTail() {
        for (int i = 0; i <= 10; i++) {
            myLinkedList.add(i);
        }
        Iterator<Integer> iterator = myLinkedList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(5)) {
                iterator.remove();
            }
        }
        assertEquals(10, myLinkedList.size());

        Iterator<Integer> iterator1 = myLinkedList.iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next().equals(10)) {
                iterator.remove();
            }
        }
    }

    @Test
    void checkExceptionForNotImplementedMethod() {
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.addAll(1, myLinkedList));
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.toArray(new Object[]{1, 2, 3}));
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.removeAll(myLinkedList));
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.retainAll(myLinkedList));
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.lastIndexOf(3));
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.listIterator());
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.listIterator(3));
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.subList(10, 15));
    }
}