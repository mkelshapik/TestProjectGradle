package javaMain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    MyHashMap<String, Integer> myHashMap = new MyHashMap<>();

    /////// Step 1. Check correct work of basic methods
    @Test
    void isEmpty() {
        assertTrue(myHashMap.isEmpty());
        myHashMap.put("First", 1);
        assertFalse(myHashMap.isEmpty());
        myHashMap.remove("First");
        assertTrue(myHashMap.isEmpty());
    }

    @Test
    void size() {
        myHashMap.put("1", 1);
        assertEquals(1, myHashMap.size(), "Size isn`t equal 1!");
        myHashMap.put("2", 2);
        myHashMap.put("3", 3);
        myHashMap.put("4", 4);
        assertEquals(4, myHashMap.size(), "Size isn`t equal 4!");
        myHashMap.put("5", 5);

        myHashMap.remove("3");
        assertEquals(4, myHashMap.size(), "Size isn`t equal 4!");
        myHashMap.remove("1");
        myHashMap.remove("5");
        assertEquals(2, myHashMap.size(), "Size isn`t equal 2!");
        myHashMap.remove("4");

        myHashMap.clear();
        assertEquals(0, myHashMap.size(), "Size isn`t equal 0!");
        assertTrue(myHashMap.isEmpty());
    }

    @Test
    void putGetRemove() {
        myHashMap.put("0", null);
        myHashMap.put("1", 1);
        myHashMap.put("2", 2);
        myHashMap.put("3", 3);
        myHashMap.put("4", 4);
        myHashMap.put("5", 5);
        myHashMap.put("6", 6);
        myHashMap.put("7", 7);
        myHashMap.put("8", 8);
        myHashMap.put("", 9);
        assertNull(myHashMap.get("0"));
        assertEquals(1, myHashMap.get("1"));
        assertEquals(2, myHashMap.get("2"));
        assertEquals(9, myHashMap.get(""));
        assertEquals(6, myHashMap.remove("6"));
        assertEquals(9, myHashMap.remove(""));
        assertEquals(8, myHashMap.remove("8"));
        assertNull(myHashMap.remove("0"));
        assertNull(myHashMap.remove(""));
        myHashMap.clear();
        assertEquals(0, myHashMap.size());
    }

    @Test
    void containsKeyValue() {
        myHashMap.put("10", 10);
        myHashMap.put("", 11);
        myHashMap.put("3", 13);
        myHashMap.put("4", null);
        myHashMap.put("5", 15);
        myHashMap.put("10", 16);

        assertFalse(myHashMap.containsValue(10));
        assertTrue(myHashMap.containsValue(null));
        assertTrue(myHashMap.containsKey(""));
        assertFalse(myHashMap.containsKey("NULL"));
        assertTrue(myHashMap.containsValue(16));
    }

    /////// Step 2. A few attempt to crash my HashMap

    @Test
    void addWithLoop() {
        MyHashMap<Integer, Integer> integer = new MyHashMap<>();
        for (int i = 0; i < 100; i++) {
            integer.put(i + 1000, i + 10);
            assertEquals(i + 10, integer.get(i + 1000));
            assertTrue(integer.containsValue(i + 10));
        }
    }

    @Test
    void addLoopStr() {
        String str = "0";

        for (int i = 0; i < 20; i++) {
            str += i;
            System.out.println(str);
            myHashMap.put(str, i);
        }
        //tableIndex(K key) method was changed.
        // Math.abs() was added inside because too long string gave negative index.
    }

    @Test
    void charTest() {
        MyHashMap<Character, Integer> character = new MyHashMap<>();
        for (int i = 65; i < 123; i++) {
            Character a = (char) i;
            character.put(a, i);
            assertTrue(character.containsValue(i));
        }
        character.remove('A');
        character.remove('B');
        character.remove('C');
        character.remove('D');
        character.remove('F');
        character.remove('G');
        character.remove('H');
        character.remove('I');
        character.remove('J');
        character.remove('K');
        character.remove('L');
        character.remove('M');
        character.remove('N');
        character.remove('O');
        character.remove('P');
        character.remove('Q');
    }

    @Test
    void checkWhenGetMethodReturnNull() {
        assertNull(myHashMap.get("NULL"));
    }

    @Test
    void checkIfWeHaveDifferentClassesForKeys() {
        myHashMap.put("1", 1);
        assertFalse(myHashMap.containsKey('1'));
    }

//    @Test
//    void checkEqualsMethodIfObjEqualsNull() {
//        // HashMap can contain null key!!!
//        String str = null;
//        myHashMap.put(null, 1);
//        assertFalse(myHashMap.containsKey(null));
//    }

    @Test
    void checkNotImplementedMethods() {
        assertThrows(IndexOutOfBoundsException.class, () -> myHashMap.keySet());
        assertThrows(IndexOutOfBoundsException.class, () -> myHashMap.putAll(myHashMap));
        assertThrows(IndexOutOfBoundsException.class, () -> myHashMap.values());
        assertThrows(IndexOutOfBoundsException.class, () -> myHashMap.entrySet());
    }

    @Test
    void checkHashCodeMethodForClassNode() {
        Integer i = 1;
        MyHashMap.Node<Integer, Integer> testNode = new MyHashMap.Node<Integer, Integer>(i, 1);
        assertEquals(Objects.hash(i), testNode.hashCode());
    }
}