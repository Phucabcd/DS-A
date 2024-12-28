package hashTable;

public class Node<K, V> {
    private int hash;
    private K key;
    private V value;

    public Node(K key, V value, int hash) {
        this.key = key;
        this.value = value;
        this.hash = hash;
    }

    public boolean aquals(Node<K,V>other) {
        if(other.hash!=hash)return false;
        return key.equals(other.key);
    }

    @Override
    public String toString() {
        return "key" + key + "value" + value;
    }
}
