class WordDictionary {
    class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isEnd;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isEnd = false;
        }
    }
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    public boolean dfs(TrieNode curr, String word, int index) {
        if (index == word.length()) {
            return curr.isEnd;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (char key : curr.children.keySet()) {
                if (dfs(curr.children.get(key), word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            return dfs(curr.children.get(c), word, index + 1);
        }
    }

}
