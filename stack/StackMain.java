package stack;

public class StackMain {
    public static void main(String[] args) {
        int numberOfOperations = 10000000;

        StackADT<Integer> arrayStack = new ArrayBasedStack<>(10);

        //ArrayBaseStack
        long startTime = System.nanoTime();
        for(int i = 0; i < numberOfOperations; i++){
            arrayStack.push(i);
        }


        //error pop
        /*for(int i = 0; i < numberOfOperations; i++){
            arrayStack.pop();
        }*/
        long endTime = System.nanoTime();
        System.out.println("Array base stack: " + (endTime - startTime) + "\n");


        //LinkedListStack
        StackADT<Integer> linkedListStack = new LinkedListStack<>();

        startTime = System.nanoTime();
        for(int i = 0; i < numberOfOperations; i++){
            linkedListStack.push(i);
        }

        for(int i = 0; i < numberOfOperations; i++){
            linkedListStack.pop();
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList base stack: " + (endTime - startTime) + "\n");
    }

}