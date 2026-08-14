class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next; 
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            next = null;
            prev = null;
        }

    }
    int cap;
    Node left;
    Node right;
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        cap = capacity;
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
        map = new HashMap<>();
    }

    public void remove(Node curr) {
        Node prev = curr.prev;
        Node next = curr.next;
        next.prev = prev;
        prev.next = next;
    }
    
    public void add(Node curr) {
        Node next = left.next;
        left.next = curr;
        curr.prev = left;
        curr.next = next;
        next.prev = curr;
    }
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node curr = map.get(key);
        remove(curr);
        add(curr);
        return curr.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        Node curr = new Node(key, value);
        map.put(key, curr);
        add(curr);
        if (map.size() > cap) {
            Node removed = right.prev;
            remove(removed);
            map.remove(removed.key);
        }
    }
}
