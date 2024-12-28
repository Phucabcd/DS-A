package dynamicArray;

public class main {
    public static void main(String[] args) {
        DynamicArray<String> dynamicArray = new DynamicArray<String>();
        dynamicArray.add("P");
        dynamicArray.add("H");
        dynamicArray.add("U");
        dynamicArray.add("C");
        System.out.println(dynamicArray); // Should print [1, 2, 3, 4]
        dynamicArray.removeAt(2);
        System.out.println(dynamicArray); // Should print [1, 2, 4]
        dynamicArray.remove(4);
        System.out.println(dynamicArray); // Should print [1, 2]
    }
}
