package javaMain;

import javaMain.MyQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    MyQueue<Integer> myQueue = new MyQueue<>();

    @Test
    void emptyQueue() {
        // check if Queue is empty
        assertTrue(myQueue.isEmpty(), "Queue isn`t empty!");
    }

    @Test
    void nonEmptyQueue() {
        // check if Queue isn`t Empty
        myQueue.offer(1);
        assertFalse(myQueue.isEmpty(), "Queue is Empty!");
    }

    @Test
    void offer() {
        // check head
        myQueue.offer(1);
        assertEquals(1, myQueue.peek(), "It isn`t head!");
        myQueue.offer(2);
        assertEquals(1, myQueue.peek(), "It isn`t head!");
        myQueue.offer(3);
        assertEquals(1, myQueue.peek(), "It isn`t head!");
        myQueue.offer(4);
        assertEquals(1, myQueue.peek(), "It isn`t head!");
    }

    @Test
    void poll() {
        // check if poll() return and delete first added element
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);

        assertEquals(1, myQueue.poll(), "It isn`t first element!");
        assertEquals(2, myQueue.poll(), "It isn`t first element!");
        assertEquals(3, myQueue.poll(), "It isn`t first element!");

        assertTrue(myQueue.isEmpty(), "Queue isn`t Empty!");

    }

    @Test
    void peek() {
        // check if peek() return null for free queue and fist element without deleting for queue with some element
        assertNull(myQueue.peek(), "It isn`t null!");

        myQueue.offer(1);
        assertEquals(1, myQueue.peek(), "It isn`t first element!");

        myQueue.offer(2);
        myQueue.offer(3);

        myQueue.poll();

        assertEquals(2, myQueue.peek(), "It isn`t first element!");
        assertFalse(myQueue.isEmpty(), "Queue is Empty!");
    }

    @Test
    void checkPollIfHeadEqualsNull() {
        assertNull(myQueue.poll());
    }
}