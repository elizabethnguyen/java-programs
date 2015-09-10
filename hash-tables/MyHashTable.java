import java.util.*;

public class MyHashTable {

    public class Node {
        public Object key = null;
        public Object value = null;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }

    public static final int DEFAULT_SIZE = 16;
    public static final int GROWTH_FACTOR = 2;
    public Node[] table = null;
    public int numElements = 0;

    public MyHashTable() {
        table = new Node[DEFAULT_SIZE];
    }

    public MyHashTable(int size) {
        table = new Node[size];
    }

    public Object put(Object key, Object value) {
        if (numElements == table.length) {
            rehash();
            return put(key, value);
        }
        int index = Math.abs(key.hashCode()) % table.length;
        if (table[index] != null) {
            index = nextVacantIndex(index);
        }

        table[index] = new Node(key, value);
        numElements++;
        return value;
    }

    public Object get(Object key) {
        int index = Math.abs(key.hashCode()) % table.length;
        if (table[index].key != key) {
            index = findKey(index, key);
            if (index == -1) {
                return null;
            }
        }

        return table[index].value;
    }

    public Object remove(Object key) {
        int index = Math.abs(key.hashCode()) % table.length;
        index = findKey(index, key);
        if (index == -1) {
            return null;
        }
        Object value = table[index].value;
        table[index] = null;
        numElements--;

        return value;
    }

    private int findKey(int index, Object key) {
        if (table[index] != null && table[index].key.equals(key)) {
            return index;
        }
        int i = (index + 1) % table.length;
        while (i != index) {
            if (table[i] != null && table[i].key.equals(key)) {
                return i;
            }

            i = (i+1) % table.length;
        }

        return -1;
    }

    public void rehash() {
        Node[] oldTable = table;
        table = new Node[table.length*GROWTH_FACTOR];
        numElements = 0;

        for (Node node : oldTable) {
            put(node.key, node.value);
        }
    }

    private int nextVacantIndex(int index) {
        int i = (index + 1) % table.length;
        // Credit: Big Man Sammy
        while (i != index) {
            if (table[i] == null) {
                return i;
            }

            i = (i+1) % table.length;
        }

        throw new NoSuchElementException();
    }

    public String toString() {
        String result = "[";
        int includedElements = 0;
        int i = 0;
        for (i = 0; i < table.length; i++) {
            if (table[i] != null) {
                if (includedElements == numElements - 1) {
                    result += table[i] + "]";
                    includedElements++;
                    return result;
                }
                result += table[i] + ", ";
                includedElements++;
            }
        }
        if (numElements == 0) {
            result += "]";
        }
        return result;
    }
}
