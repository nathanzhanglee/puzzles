class PrefixTree {
    class Node {
        char val;
        Node[] neighbors;
        boolean end;

        public Node(char val) {
            this.val = val;
            neighbors = new Node[26];
            end = false;
        }
    }

    Node[] sources;
    public PrefixTree() {
        this.sources = new Node[26];
    }

    public void insert(String word) {
        if (word.isEmpty()) {
            return;
        }
        int i = 0;
        Node curr = null;
        Node[] next = sources;
        while (i < word.length() && next[word.charAt(i) - 'a'] != null) {
            curr = next[word.charAt(i) - 'a'];
            next = curr.neighbors;
            i++;
        }
        while (i < word.length()) {
            curr = new Node(word.charAt(i));
            next[curr.val - 'a'] = curr;
            next = curr.neighbors; 
            i++;
        }
        curr.end = true;
    }

    public boolean search(String word) {
        if (word.isEmpty()) {
            return false;
        }
        int i = 0;
        Node curr = null;
        Node[] next = sources;
        while (i < word.length() && next[word.charAt(i) - 'a'] != null) {
            curr = next[word.charAt(i) - 'a'];
            next = curr.neighbors;
            i++;
        }
        if (curr != null && i == word.length() && curr.end) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) {
            return true;
        }
        int i = 0;
        Node curr = null;
        Node[] next = sources;
        while (i < prefix.length() && next[prefix.charAt(i) - 'a'] != null) {
            curr = next[prefix.charAt(i) - 'a'];
            next = curr.neighbors;
            i++;
        }
        if (curr != null && i == prefix.length()) {
            return true;
        }
        return false;
    }
}
