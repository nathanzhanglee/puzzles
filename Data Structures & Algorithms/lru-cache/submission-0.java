class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key, int value) {
            this.key = key;
            this.val = value;
            this.next = null;
            this.prev = null;
        }
    }
    HashMap<Integer, Node> map;
    int cap;
    Node left;
    Node right;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }
    
    public void insert(Node curr) {
        Node oldPrev = right.prev;
        oldPrev.next = curr;
        curr.prev = oldPrev;
        curr.next = right;
        right.prev = curr;
    }

    public void remove(Node curr) {
        Node oldPrev = curr.prev;
        Node oldNext = curr.next;
        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            remove(curr);
            insert(curr);
            return curr.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            map.remove(key);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);
        if (map.size() > cap) {
            Node removed = left.next;
            remove(removed);
            map.remove(removed.key);
        }
    }
}
