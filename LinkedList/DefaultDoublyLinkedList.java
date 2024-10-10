package LinkedList;

import java.util.Iterator;

public class DefaultDoublyLinkedList<T> implements DoublyLinkedList<T> {
    private int size;
    private Node<T> head = null;
    private Node<T> tail = null;

    @Override
    public void clear() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            Node<T> nextNode = currentNode.getNext();
            currentNode.setNext(null);
            currentNode.setPrev(null);
            currentNode.setData(null);
            currentNode = nextNode;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void add(T element) {
        addLast(element);
    }

    @Override
    public void addFirst(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else {
            Node<T> newNode = new Node<>(element, null, head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else {
            Node<T> newNode = new Node<>(element, tail, null);
            tail.setNext(newNode);
            tail = tail.getNext();
        }
        size++;
    }

    @Override
    public T peekFirst() {
        if (isEmpty()) return null;
        return head.getData();
    }

    @Override
    public T peekLast() {
        if (isEmpty()) return null;
        return tail.getData();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) return null;
        T data = head.getData();
        head = head.getNext();
        if (head != null) {
            head.setPrev(null);
        } else {
            tail = null;  // Nếu danh sách chỉ còn một phần tử
        }
        size--;
        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) return null;
        T data = tail.getData();
        tail = tail.getPrev();
        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null;  // Nếu danh sách chỉ còn một phần tử
        }
        size--;
        return data;
    }

    @Override
    public T remove(Node<T> node) {
        if (node == null) return null;

        if (node == head) {
            return removeFirst();
        } else if (node == tail) {
            return removeLast();
        } else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }

        size--;
        return node.getData();
    }

    @Override
    public T remove(Object object) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData().equals(object)) {
                return remove(currentNode);
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    @Override
    public T removeAt(int index) {
        if (index < 0 || index >= size) return null;
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return remove(currentNode);
    }

    @Override
    public int indexOf(Object object) {
        Node<T> currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.getData().equals(object)) {
                return index;
            }
            currentNode = currentNode.getNext();
            index++;
        }
        return -1;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }
}
