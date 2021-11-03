package javaMain;

import javaMain.MyHashSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashSetTest {
    MyHashSet<Integer> myHashSet = new MyHashSet<>();

    /////// Step 1. Check correct work of basic methods
    @Test
    void size() {
        assertEquals(0, myHashSet.size());
        myHashSet.add(0);
        myHashSet.add(1);
        myHashSet.add(2);
        myHashSet.add(3);
        myHashSet.add(4);
        myHashSet.add(4);
        assertEquals(5, myHashSet.size());
        myHashSet.add(5);
        myHashSet.add(6);
        myHashSet.add(7);
        myHashSet.add(8);
        myHashSet.add(9);
        myHashSet.add(10);
        assertEquals(11, myHashSet.size());
        myHashSet.add(11);
        assertEquals(12, myHashSet.size());
        myHashSet.add(12);
        assertEquals(13, myHashSet.size());
        myHashSet.add(13);
        myHashSet.add(14);
        assertEquals(15, myHashSet.size());
        myHashSet.add(15);
        assertEquals(16, myHashSet.size());
        myHashSet.add(16);
        assertEquals(17, myHashSet.size());
        myHashSet.add(17);
        myHashSet.add(18);
        assertEquals(19, myHashSet.size());
    }

    @Test
    void isEmpty() {
        assertTrue(myHashSet.isEmpty());
        myHashSet.add(1);
        myHashSet.add(2);
        myHashSet.add(3);
        myHashSet.add(4);
        myHashSet.remove(1);
        myHashSet.remove(2);
        myHashSet.remove(3);
        myHashSet.remove(4);
        assertTrue(myHashSet.isEmpty());
    }

    @Test
    void add() {
        for (int i = 0; i < 20; i++) {
            assertTrue(myHashSet.add(i));
            assertFalse(myHashSet.add(i));
        }
    }

    @Test
    void remove() {
        for (int i = 0; i < 20; i++) {
            assertTrue(myHashSet.add(i));
            assertTrue(myHashSet.remove(i));
            assertEquals(0, myHashSet.size());
            assertFalse(myHashSet.remove(i));
        }
    }

    @Test
    void clear() {
        for (int i = 0; i < 10; i++) {
            myHashSet.add(i);
        }
        myHashSet.clear();
        assertEquals(0, myHashSet.size());
    }

    @Test
    void checkUnimplementedMethods(){
        assertThrows(IndexOutOfBoundsException.class, () -> myHashSet.containsAll(myHashSet));
        assertThrows(IndexOutOfBoundsException.class, () -> myHashSet.iterator());
        assertThrows(IndexOutOfBoundsException.class, () -> myHashSet.toArray());
        assertThrows(IndexOutOfBoundsException.class, () -> myHashSet.toArray(new Object[]{1, 2}));
        assertThrows(IndexOutOfBoundsException.class, () -> myHashSet.addAll(myHashSet));
        assertThrows(IndexOutOfBoundsException.class, () -> myHashSet.retainAll(myHashSet));
        assertThrows(IndexOutOfBoundsException.class, () -> myHashSet.removeAll(myHashSet));
    }
}