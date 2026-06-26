class LRUCache {
    public class Node{
        Node next;
        Node prev;
        int key;
        int value;
        public Node(int key, int value) {
            this.next = null;
            this.prev = null;
            this.key = key;
            this.value = value;    
        }
    }

    Node left;
    Node right;
    HashMap<Integer, Node> map;
    int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.prev = null;
        this.left.next = right;
        this.right.prev = left;
        this.right.next = null;
    }
    
    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void insert(Node node) {
        Node prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
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
            remove(map.get(key));
            map.remove(key);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);
        if (map.size() > cap) {
            map.remove(left.next.key);
            remove(left.next);
        }
    }
}
