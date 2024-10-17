package Tree;

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements TreeADT<T> {
    private int nodeCount = 0;

    private Node<T> root = null;

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return nodeCount;
    }

    @Override
    public int height() {
        return height(root);
    }

    @Override
    public boolean contains(T elem) {
        return contains(root, elem);
    }

    @Override
    public boolean add(T elem) {
        if (contains(elem)) return false;

        root = add(root, elem);
        nodeCount++;
        return true;
    }

    @Override
    public boolean remove(T elem) {
        if (!contains(elem)) return false;
        root = remove(root, elem);
        nodeCount--;
        return true;
    }

    @Override
    public Iterator<T> traverse(TreeTraverseType type) {
        return null;
    }

    //PRIVATE

    private int height(Node node) {
        if (node == null) return 0;

        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    private boolean contains(Node node, T elem) {
        if (node == null) return false;

        int result = elem.compareTo((T) node.getData());

        if (result < 0) return contains(node.getLeft(), elem);

        else if (result > 0) return contains(node.getRight(), elem);

        else return true;
    }

    private Node add(Node node, T elem) {
        if (node == null) {
            node = new Node(elem, null, null);
        } else {
            if (elem.compareTo((T) node.getData()) > 0) {
                node.setRight(add(node.getRight(), elem));
            } else {
                node.setLeft(add(node.getLeft(), elem));
            }
        }
        return node;
    }

    private Node remove(Node node, T elem) {
        int result = elem.compareTo((T) node.getData());
        if (result > 0) {
            node.setRight(remove(node.getRight(), elem));
        } else if (result < 0) {
            node.setLeft(remove(node.getLeft(), elem));
        } else {
            if (node.getLeft() == null) {
                Node rightNode = node.getRight();

                node.setData(null);
                node = null;
                return rightNode;
            } else if (node.getRight() == null) {
                Node leftNode = node.getLeft();

                node.setData(null);
                node = null;
                return leftNode;
            } else {
                T tmp = minRight(node);

                node.setData(tmp);

                node.setRight(remove(node.getRight(), tmp));
            }
        }
        return node;
    }
    private T minRight(Node node) {
        while (node.getLeft() != null) node = node.getLeft();
        return (T) node.getData();
    }

    private T maxLeft(Node node) {
        while (node.getRight() != null) node = node.getRight();
        return (T) node.getData();
    }
}



