import java.util.*;

class Node {
    int key;
    String value;
    int freq;
    Node prev;
    Node next;
    
    public Node(int key, String value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;
    int size;
    
    public DoublyLinkedList() {
        head = new Node(0, "head");
        tail = new Node(0, "tail");
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    public void add(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }
    
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }
    
    public Node removeLast() {
        if (size > 0) {
            Node last = tail.prev;
            remove(last);
            return last;
        }
        return null;
    }
}

public class LFUCachePolicy {
    private int capacity;
    private int minFreq;
    private Map<Integer, Node> keyToNode;
    private Map<Integer, DoublyLinkedList> freqToList;
    
    public LFUCachePolicy(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToNode = new HashMap<>();
        this.freqToList = new HashMap<>();
    }
    
    // tem que ser O(1)
    private void updateFreq(Node node) {
    }
    
    // tem que ser O(1)
    public String get(int key) {
        return null;
    }
    
    // tem que ser O(1)
    public void put(int key, String value) {
    }
    
    
    public static void main(String[] args) {
        LFUCachePolicy cache = new LFUCachePolicy(2);
        
        cache.put(1, "a");
        cache.put(2, "b");
        assert cache.get(1).equals("a");
        cache.put(3, "c");                       // remove key 2
        assert cache.get(2) == null;      // returns null (not found)
        assert cache.get(3).equals("c");
        cache.put(4, "d");                       // remove key 1
        assert cache.get(2) == null;      // returns null (not found)
        assert cache.get(3).equals("c");
        assert cache.get(4).equals("d");
    }
}