class WordDictionary {
    public class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean end = false;
    }
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        int i = 0;
        while (i < word.length()) {
            if (!curr.children.containsKey(word.charAt(i))) {
                curr.children.put(word.charAt(i), new TrieNode());
            }
            curr = curr.children.get(word.charAt(i));
            i++;
        }
        curr.end= true;
    }

    public boolean search(String word) {
        return dfs(root, 0, word);
    }

    public boolean dfs(TrieNode curr, int index, String word) {
        if (index == word.length()) {
            return curr.end;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (char key : curr.children.keySet()) {
                if (dfs(curr.children.get(key), index + 1, word)) {
                    return true;
                }
            }
        } else {
            if (curr.children.containsKey(c)) {
                return dfs(curr.children.get(c), index + 1, word);
            }
        }
        return false;
    }
}
