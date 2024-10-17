package Tree;

import java.util.Iterator;

public class main {
    public static void main(String[] args) {
        TreeADT<Integer> bst = new BinarySearchTree<>();

        bst.add(5);
        bst.add(7);
        bst.add(8);
        bst.add(9);
        bst.add(10);
        bst.add(6);

        Iterator traverse = bst.traverse(TreeTraverseType.IN_ORDER);

        while (traverse.hasNext()) {
            System.out.println(traverse.next());
        }
        System.out.println(bst.height());
        System.out.println(bst.contains(10));
        System.out.println(bst.contains(4));


    }
}
