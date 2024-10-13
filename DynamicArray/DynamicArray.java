package DynamicArray;


import java.util.Iterator;
import java.util.Scanner;

public class DynamicArray<T> implements Iterable<T> {

    private T[] arr;
    private int size = 0; // Number of elements in the array
    private int capacity = 0; // Current capacity of the array

    public DynamicArray() {
        this(10);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity cannot be negative: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        return arr[index];
    }

    public void set(int index, T element) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        arr[index] = element;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size = 0;
    }

    public void add(T element) {
        if (size == capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2;

            T[] newArr = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[size++] = element;
    }

    public void removeAt(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();

        T[] newArr = (T[]) new Object[size - 1];

        for (int i = 0, j = 0; i < size; i++, j++) {
            if (i == index) j--;
            else newArr[j] = arr[i];
        }
        arr = newArr;
        size--;
    }

    public T removeAtWithoutMoving(int removeIndex){
        if(removeIndex >= size || removeIndex < 0){
            throw new IndexOutOfBoundsException();
        }
        T item = arr[removeIndex];
        arr[removeIndex] = null;
        --size;
        return item;
    }

    public void remove(Object object) {
        int removeIndex = indexOf(object);
        if (removeIndex != -1) {
            removeAt(removeIndex);
        }
    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object == null && arr[i] == null) {
                return i;
            } else if (object != null && object.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                return arr[currentIndex++];
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(arr[i]).append(", ");
        }
        sb.append(arr[size - 1]).append("]");
        return sb.toString();
    }}
