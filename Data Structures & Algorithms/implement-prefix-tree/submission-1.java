class PrefixTree {
    public class Node {
        HashMap<Character, Node> mapping = new HashMap<>();
        boolean end = false;
    }
    Node source;
    public PrefixTree() {
        this.source = new Node();
    }

    public void insert(String word) {
        Node curr = source;
        for (char c : word.toCharArray()) {
            curr.mapping.putIfAbsent(c, new Node());
            curr = curr.mapping.get(c);
        }
        curr.end = true;
    }

    public boolean search(String word) {
        Node curr = source;
        for (char c : word.toCharArray()) {
            if (!curr.mapping.containsKey(c)) {
                return false;
            }
            curr = curr.mapping.get(c);
        }
        return curr.end;
    }

    public boolean startsWith(String prefix) {
        Node curr = source;
        for (char c : prefix.toCharArray()) {
            if (!curr.mapping.containsKey(c)) {
                return false;
            }
            curr = curr.mapping.get(c);
        }
        return true;
    }
}
