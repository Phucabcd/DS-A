package hashTable;

import linkedList.DoublyLinkedList;

import java.util.Iterator;

public class SeparateChainingFlashTable<K,V> implements HashTableADT<K, V>{
    private static final int DEFAULT_CAPACITY = 10;
    private static final double DEFAULT_LOAD_FACTOR = 0.5;

    private final double loadFactor;
    private int size = 0, capacity, threshold;

    private DoublyLinkedList<Node<K,V>> table;

    public SeparateChainingFlashTable(int capacity, double loadFactor) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity must be a positive integer");
        if (loadFactor <= 0 || Double.isNaN(loadFactor) || Double.isInfinite(loadFactor)) {
            throw new IllegalArgumentException("Load factor must be a positive number");
        }
        this.loadFactor = loadFactor;
        this.capacity = Math.max(DEFAULT_CAPACITY, capacity);
        this.threshold = (int) (this.capacity *loadFactor);
    }



    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int hashCodeToIndex(int hashedKey) {
        return 0;
    }

    @Override
    public void clean() {

    }

    @Override
    public boolean has(K key) {
        return false;
    }

    @Override
    public V insert(K key, V value) {
        return null;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }
}
