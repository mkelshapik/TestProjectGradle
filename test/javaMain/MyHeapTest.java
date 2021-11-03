package javaMain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class MyHeapTest {
    @Test
    void add() {
        // in this case i add a few elements (from 0 to 20),
        // and overload compare method. He has to sort heap from the bigger
        // to the smallest element in heap
        // than i check it by poll method
        MyHeap<Integer> myHeap = new MyHeap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i <= 20; i++) {
            myHeap.add(i);
        }
        for (int i = 20; i > 0; i--) {
            assertEquals(i, myHeap.poll());
        }
    }

    @Test
    void peek() {
        // in this method i want to check peek method
        // firstly i overload compare method that he sort heap from
        // the smallest to the bigger element
        // than i add ten elements and start to check it
        // using poll and peek methods
        MyHeap<String> animals = new MyHeap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        animals.add("Duck");
        animals.add("Elephant");
        animals.add("Cat");
        animals.add("Turtle");
        animals.add("Dog");
        // check size
        assertEquals(5, animals.size());
        animals.add("Shark");
        animals.add("Snail");
        animals.add("Snake");
        animals.add("Rabbit");
        animals.add("Chicken");

        assertEquals("Cat", animals.peek());
        assertEquals("Cat", animals.poll());
        assertEquals("Chicken", animals.poll());
        assertEquals("Dog", animals.poll());
        assertEquals("Duck", animals.poll());
        assertEquals("Elephant", animals.peek());
        assertEquals("Elephant", animals.poll());
        assertEquals("Rabbit", animals.poll());
        assertEquals("Shark", animals.peek());
        assertEquals("Shark", animals.poll());
        assertEquals("Snail", animals.poll());
        assertEquals("Snake", animals.poll());
        assertEquals("Turtle", animals.peek());
        assertEquals("Turtle", animals.poll());

        assertThrows(IllegalStateException.class, animals::peek);
        assertThrows(IllegalStateException.class, animals::poll);
    }

//    @Test
//    void hasParent() {
//        // here i have to check hasParent method
//        // if i pass negative index
//        // i need use reflection for this
//        MyHeap<Integer> integers = new MyHeap<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//        integers.add(10);
//        try {
//            Method hasParent = integers.getClass().getDeclaredMethod("hasParent", int.class);
//            hasParent.setAccessible(true);
//            assertFalse((Boolean) hasParent.invoke(integers, -1));
//            assertTrue((Boolean) hasParent.invoke(integers, 1));
//        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
}