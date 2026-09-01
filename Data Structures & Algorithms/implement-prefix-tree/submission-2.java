class PrefixTree {

    class Node {
        Node[] children;
        boolean isEnd;
        
        public Node() {
            this.children = new Node[26];
            this.isEnd = false;
        }
    }

    Node root;
    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        int index = 0;
        while (index < word.length() && curr.children[word.charAt(index) - 'a'] != null) {
            curr = curr.children[word.charAt(index) - 'a'];
            index++;
        }
        while (index < word.length()) {
            curr.children[word.charAt(index) - 'a'] = new Node();
            curr = curr.children[word.charAt(index) - 'a'];
            index++;
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Node curr = root;
        int index = 0;
        while (index < word.length() && curr.children[word.charAt(index) - 'a'] != null) {
            curr = curr.children[word.charAt(index) - 'a'];
            index++;
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        int index = 0;
        while (index < prefix.length() && curr.children[prefix.charAt(index) - 'a'] != null) {
            curr = curr.children[prefix.charAt(index) - 'a'];
            index++;
        }
        return index == prefix.length();
    }
}
