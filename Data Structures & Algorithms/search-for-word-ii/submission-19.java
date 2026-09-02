class Solution {
    class Node {
        HashMap<Character, Node> children;
        boolean isEnd;
        public Node() {
            children = new HashMap<>();
            isEnd = false;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        for (String word : words) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                curr.children.putIfAbsent(c, new Node());
                curr = curr.children.get(c);
            }
            curr.isEnd = true;
        }
        Set<String> result = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, root, result, "", board, visited);
            }
        }
        return new ArrayList<>(result);
    }

    public void dfs(int row, int col, Node curr, Set<String> result, String s, char[][] board, boolean visited[][]) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] || !curr.children.containsKey(board[row][col])) {
            return;
        }
        visited[row][col] = true;
        curr = curr.children.get(board[row][col]);
        s += board[row][col];
        if (curr.isEnd) {
            result.add(s);
        }
        dfs(row + 1, col, curr, result, s, board, visited);
        dfs(row, col + 1, curr, result, s, board, visited);
        dfs(row - 1, col, curr, result, s, board, visited);
        dfs(row, col - 1, curr, result, s, board, visited);
        visited[row][col] = false;
    }
}
