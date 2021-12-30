class Node {
    int key;
    int value;
    Node pre;
    Node next;
    public Node (){}
    public Node (int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    Map<Integer, Node> map = new HashMap<Integer, Node>();
    int capacity;
    int size;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();  
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            addNode(node);
            map.put(key, node);
            size++;
            if (size > capacity) {
                Node toRemove = popTail();
                map.remove(toRemove.key);
                size--;
            } 
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
    
    // always add to head
    private void addNode(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }
    
    // pop the Least recently used node from tail
    private Node popTail() {
        Node node = tail.pre;
        removeNode(node);
        return node;
    }
    
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }
    
    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */