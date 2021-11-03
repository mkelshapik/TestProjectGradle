package javaMain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    List<Integer> myArrayList = new MyArrayList<>();

    @Test
    void checkAddAndConstructor() {
        List<Integer> myArrayList1 = new MyArrayList<>(2);
        myArrayList1.add(1);
        myArrayList1.add(2);
        myArrayList1.add(3);
        myArrayList1.add(4);
        myArrayList1.add(5);
        myArrayList1.add(6);

        assertEquals(myArrayList1.get(0), 1);
        assertFalse(myArrayList1.isEmpty());
    }

    @Test
    void isEmpty() {
        // check isEmpty if adds some element into list
        myArrayList.add(1);
        assertFalse(myArrayList.isEmpty(), "ArrayList is Empty!");
    }

    @Test
    void add() {
        // check is fun add(Obj) adds element in the tail
        myArrayList.add(1);
        assertEquals(1, myArrayList.get(0), "It isn`t tail!");
        myArrayList.add(2);
        assertEquals(2, myArrayList.get(1), "It isn`t tail!");
        myArrayList.add(3);
        assertEquals(3, myArrayList.get(2), "It isn`t tail!");
    }

    @Test
    void testAdd() {
        // check exceptions(index < 0 || index > size)

        // check is fun add(index, obj) can adds element into head, tail and other pos
        myArrayList.add(2);
        myArrayList.add(0, 1);
        assertEquals(1, myArrayList.get(0));
        assertEquals(2, myArrayList.get(1));
        myArrayList.add(0, 0);
        assertEquals(0, myArrayList.get(0));

        myArrayList.add(3, 3);
        myArrayList.add(4, 4);
        myArrayList.add(5, 5);
        myArrayList.add(6, 6);
        myArrayList.add(7, 7);
        myArrayList.add(8, 8);
        assertEquals(8, myArrayList.get(8));
        myArrayList.add(9, 9);
        myArrayList.add(10, 10);
        myArrayList.add(11, 11);
        assertEquals(11, myArrayList.get(11));
        myArrayList.add(1, 25);
        assertEquals(25, myArrayList.get(1));
    }

    @Test
    void remove() {
        // check fun remove() from head, tail and other pos
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        myArrayList.add(40);
        myArrayList.add(50);
        assertEquals(5, myArrayList.size());
        assertEquals(10, myArrayList.remove(0));
        assertEquals(40, myArrayList.remove(2));
        assertEquals(30, myArrayList.remove(1));
        assertEquals(2, myArrayList.size());
    }

    @Test
    void contains() {
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        myArrayList.add(40);

        assertFalse(myArrayList.contains(1));
        assertTrue(myArrayList.contains(30));
    }

    @Test
    void clear() {
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.clear();
        assertTrue(myArrayList.isEmpty(), "fun clear() doesn`t work");
    }

    @Test
    void set() {
        myArrayList.add(0, 0);

        assertEquals(0, myArrayList.set(0, 5)); // check if fun set() return old val;
        assertEquals(5, myArrayList.get(0));
        assertEquals(1, myArrayList.size());
    }

    @Test
    void indexOf() {
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        assertEquals(2, myArrayList.indexOf(3));
        assertEquals(-1, myArrayList.indexOf(7));
    }

    @Test
    void removeObj() {
        myArrayList.add(11);
        myArrayList.add(12);
        myArrayList.add(13);
        myArrayList.add(14);
        myArrayList.add(15);
        myArrayList.add(16);
        myArrayList.add(17);
        myArrayList.add(18);

        assertTrue(myArrayList.remove((Object) 12));
        assertEquals(7, myArrayList.size());
        assertTrue(myArrayList.remove((Object) 18));
        assertEquals(17, myArrayList.get(5));
        assertTrue(myArrayList.remove((Object) 11));
        assertFalse(myArrayList.remove((Object) 25));
    }

    @Test
    void iterator() {
        myArrayList.add(0);
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);

        Integer j = 0;

        Iterator iterator = myArrayList.iterator();
        for (Object i : myArrayList) {
            assertEquals(i, myArrayList.get(j));
            j++;
        }
    }

    @Test
    void Replace() {
        // check pos of element after removing
        myArrayList.add(0);
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.add(7);
        myArrayList.add(8);
        myArrayList.add(9);

        myArrayList.remove(9);
        myArrayList.remove(0);
        myArrayList.remove(4);

        assertEquals(1, myArrayList.get(0));
        assertEquals(8, myArrayList.get(6));
        assertEquals(4, myArrayList.get(3));
    }

    @Test
    void shouldFailWhenInsertWithIndexBesideSize() {
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.add(myArrayList.size() + 1, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.add(-1, 10));
    }

    @Test
    void shouldExpandCapacityWhenSizeEqualsToCapacity() {
        MyArrayList<Integer> arrayList = new MyArrayList<>(1);

        arrayList.add(0, 0);
        arrayList.add(1, 1);
        try {
            Field capacity = arrayList.getClass().getDeclaredField("capacity");
            capacity.setAccessible(true);
            assertEquals(11, capacity.get(arrayList));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void catchExceptionIfIndexLowZeroAndMoreThanSizeInRemove() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        assertThrows(IllegalArgumentException.class, () -> list.remove(-1));
        assertThrows(IllegalArgumentException.class, () -> list.remove(2));
    }

    @Test
    void checkIllegalArgumentExceptionInGetMethod() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        assertThrows(IllegalArgumentException.class, () -> list.get(-1));
        assertThrows(IllegalArgumentException.class, () -> list.get(2));
    }

    @Test
    void checkIllegalArgumentExceptionInSetMethod() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        assertThrows(IllegalArgumentException.class, () -> list.set(-1, 10));
        assertThrows(IllegalArgumentException.class, () -> list.set(2, 12));
    }

    @Test
    void checkToArrayMethod() {
        Object[] ar = new Object[20];
        for (int i = 0; i < 20; i++) {
            myArrayList.add(i);
            ar[i] = i;
        }
        assertArrayEquals(ar, myArrayList.toArray());
    }

    @Test
    void checkConstructorThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new MyArrayList<>(0)
        );
    }

    @Test
    void checkNotImplementedMethodsThrowsException(){
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.addAll(myArrayList));
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.addAll(10, myArrayList));
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.removeAll(myArrayList));
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.lastIndexOf(1));
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.listIterator());
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.listIterator(1));
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.subList(1, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.retainAll(myArrayList));
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.containsAll(myArrayList));
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.toArray(new Object[]{1, 2, 3}));
    }
}
