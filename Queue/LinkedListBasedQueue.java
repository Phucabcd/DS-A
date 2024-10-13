package Queue;

import LinkedList.DefaultDoublyLinkedList;
import LinkedList.DoublyLinkedList;

import java.util.Iterator;

public class LinkedListBasedQueue<T> implements QueueADT<T>{
    private final DoublyLinkedList<T> linkedList = new DefaultDoublyLinkedList<>();

    public LinkedListBasedQueue() {

    }

    public LinkedListBasedQueue(T firstElement) {
        enQueue(firstElement);
    }

    @Override
    public void enQueue(T element) {
        linkedList.addLast(element);
    }

    @Override
    public T deQueue() {
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        return linkedList.removeFirst();
    }

    @Override
    public T peek() {
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        return linkedList.peekFirst();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return linkedList.iterator();
    }
}
