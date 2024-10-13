package Queue;

public class QueueMain {
    public static void main(String[] args) {
        int numberOfOperations = 10000000;

        QueueADT<Integer> arrayBasedQueue = new ArrayBasedQueue<>(numberOfOperations);

        long startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            arrayBasedQueue.enQueue(i);
        }
        for (int i = 0; i < numberOfOperations / 2; i++) {
            arrayBasedQueue.deQueue();
        }
        for (int i = 0; i < numberOfOperations / 4; i++) {
            arrayBasedQueue.enQueue(i);
        }
        for (int i = 0; i < 3 * numberOfOperations / 4; i++) {
            arrayBasedQueue.deQueue();
        }
        long endTime = System.nanoTime();
        long arrayTime = endTime - startTime;
        System.out.println("Array based queue took " + arrayTime + "\n");


        QueueADT<Integer> linkedListBasedQueue = new LinkedListBasedQueue<>();

        startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            linkedListBasedQueue.enQueue(i);
        }
        for (int i = 0; i < numberOfOperations; i++) {
            linkedListBasedQueue.deQueue();
        }
        endTime = System.nanoTime();
        long linkedListTime = endTime - startTime;
        System.out.println("LinkedList based queue took " + linkedListTime + "\n");

        System.out.println("The difference " + (linkedListTime - arrayTime)+ "\n");
    }
}
