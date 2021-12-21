class LRUCache {
    int size, capacity;
    Map<Integer, DLinkNode> cache;
    DLinkNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.cache = new HashMap<Integer, DLinkNode>();
        this.head = new DLinkNode();
        this.tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
          DLinkNode node = cache.get(key);
          moveToHead(node);
          return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
      DLinkNode node = cache.get(key);
      if (node != null) {
        node.value = value;
        moveToHead(node);
      } else {
        node = new DLinkNode();
        node.key = key;
        node.value = value;
        cache.put(key, node);
        addNode(node);
        size++;
        if(size > capacity) {
          DLinkNode tail = popTail();
          cache.remove(tail.key);
          size--;
        }
      }  
    }

    private void moveToHead(DLinkNode node) {
      removeNode(node);
      addNode(node);
    }

    // always add next to head
    private void addNode(DLinkNode node) {
      node.next = head.next;
      node.prev = head;
      head.next.prev = node;
      head.next = node;
    }

    // since there's head and tail, we don't need to worry about null node
    private void removeNode(DLinkNode node) {
      DLinkNode prev = node.prev;
      DLinkNode next = node.next;
      prev.next= next;
      next.prev = prev;
    }

    private DLinkNode popTail() {
      DLinkNode node = tail.prev;
      removeNode(node);
      return node;
    }

    class DLinkNode {
      int key;
      int value;
      DLinkNode prev;
      DLinkNode next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */