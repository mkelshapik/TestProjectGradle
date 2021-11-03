package javaMain;

import javaMain.MyStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    MyStack<Integer> myStack = new MyStack<>();

    @Test
    void nonEmpty() {
        // check fun when we add some element(must be false)
        myStack.push(1);
        assertFalse(myStack.isEmpty(), "Stack is Empty!");
    }

    @Test
    void isEmpty() {
        // check fun with free stack
        assertTrue(myStack.isEmpty(), "Stack isn`t Empty!");
        // check fun with some el
        myStack.push(10);
        assertFalse(myStack.isEmpty());
        // check after pop
        myStack.pop();
        assertTrue(myStack.isEmpty());
    }


    @Test
    void Push() {
        // check if push() adds elements to stack
        myStack.push(1);
        assertFalse(myStack.isEmpty(), "Stack is Empty!");
    }

    @Test
    void pop() {
        // check if pop() delete last element from stack
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertEquals(3, myStack.pop(), "Last element isn`t 3!");
        assertFalse(myStack.isEmpty(), "Stack is Empty!");
    }

    @Test
    void peek() {
        // check if peek() return head
        myStack.push(1);
        assertEquals(1, myStack.peek(), "Head does not equal 1!");
        myStack.push(2);
        assertEquals(2, myStack.peek(), "Head does not equal 2!");
        myStack.push(3);
        assertEquals(3, myStack.peek(), "Head does not equal 3!");
    }

    @Test
    void catchNullIfHeadEqualsNullInPOPAndPEEKMethods() {
        assertNull(myStack.pop());
        assertNull(myStack.peek());
    }
}