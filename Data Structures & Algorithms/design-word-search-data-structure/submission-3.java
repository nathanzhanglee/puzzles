class WordDictionary {
    class Node {
        HashMap<Character, Node> children;
        boolean isEnd;
        
        public Node() {
            children = new HashMap<>();
            isEnd = false;
        }
    }
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        int index = 0;
        while (index < word.length() && curr.children.containsKey(word.charAt(index))) {
            curr = curr.children.get(word.charAt(index));
            index++;
        }
        while (index < word.length()) {
            curr.children.put(word.charAt(index), new Node());
            curr = curr.children.get(word.charAt(index));
            index++;
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, 0, word);
    }
    
    public boolean dfs(Node curr, int index, String word) {
        if (index == word.length()) {
            return curr.isEnd;
        }
        if (word.charAt(index) == '.') {
            for (char key : curr.children.keySet()) {
                if (dfs(curr.children.get(key), index + 1, word)) {
                    return true;
                }
            }
            return false;
        } else {
            if (curr.children.get(word.charAt(index)) == null) {
                return false;
            }
            return dfs(curr.children.get(word.charAt(index)), index + 1, word);
        }
    }
}
