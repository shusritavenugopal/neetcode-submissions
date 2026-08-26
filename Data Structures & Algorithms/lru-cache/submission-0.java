class ListNode {
    int key;
    int value;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    int capacity;
    HashMap<Integer, ListNode> map;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
       this.capacity = capacity;
       map = new HashMap<>();

       head = new ListNode(-1, -1);
       tail = new ListNode(-1, -1);

       head.next = tail;
       tail.prev = head; 
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        ListNode node = map.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode toDelete = map.get(key);
            remove(toDelete);
        }

        ListNode newNode = new ListNode(key, value);
        add(newNode);
        map.put(key, newNode);

        if (map.size() > capacity) {
            ListNode deleteNode = head.next;
            remove(deleteNode);
            map.remove(deleteNode.key);
        }
    }

    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add(ListNode node) {
        ListNode previousNode = tail.prev;
        previousNode.next = node;
        node.prev = previousNode;
        node.next = tail;
        tail.prev = node;
    }
}
