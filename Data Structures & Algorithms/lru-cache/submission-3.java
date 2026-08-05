class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
            prev = null; 
        }
    }
    Node left;
    Node right;
    HashMap<Integer, Node> map;
    int cap;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }

    public void remove(Node curr) {
        curr.prev.next = curr.next;
        curr.next = curr.prev;
        map.remove(curr.key);
    }

    public void insert(Node curr) {
        Node next = left.next;
        left.next = curr;
        curr.prev = left;
        curr.next = next;
        next.prev = curr;
        map.put(curr.key, curr);
    }
    

    public int get(int key) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            remove(curr);
            insert(curr);
            return curr.value;
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            remove(curr);
        } 
        Node curr = new Node(key, value);
        insert(curr);
        if (map.size() > cap) {
            remove(right.prev);
        }
    }
}
