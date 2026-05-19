package Design;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key, value;
    Node next, prev;
    Node (int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    private int CAPACITY;
    private Map<Integer, Node> cacheMap;
    private Node head;
    private Node tail;
    public LRUCache(int capacity) {
        CAPACITY = capacity;
        cacheMap = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        } else {
            Node valueNode = cacheMap.get(key);
            int value = valueNode.value;
            removeNodeFromList(valueNode);
            addNodeNextToHead(valueNode);
            return value;
        }
        /*
            if not in Map
                return -1
            if present in Map
                get Node's value from the Map
                removeNodeFromList
                addNodeNextToHead
                return Node 
        */
    }
    
    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (cacheMap.containsKey(key)) {
            Node existingNode = cacheMap.get(key);
            removeNodeFromList(existingNode);
            addNodeNextToHead(newNode);
            cacheMap.put(key, newNode);
        } else {
            if (cacheMap.size() < CAPACITY) {
                addNodeNextToHead(newNode);
                cacheMap.put(key, newNode);
            } else {
                Node nodeToBeRemoved = tail.prev;
                removeNodeFromList(nodeToBeRemoved);
                cacheMap.remove(nodeToBeRemoved.key);
                addNodeNextToHead(newNode);
                cacheMap.put(key, newNode);
            }
        }
        /*
            if Key exists in Map
                -> yes
                    removeNodeFromList
                    addNodeNextToHead
                    addToMap
                -> no
                    if Map is not at limit
                        addNodeNextToHead
                        addToMap
                    else
                        removeNodeFromList(tail.prev)
                        removeFromMap
                        addNodeNextToHead
                        addToMap

        */
    }

    public void addNodeNextToHead (Node node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    public void removeNodeFromList (Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
