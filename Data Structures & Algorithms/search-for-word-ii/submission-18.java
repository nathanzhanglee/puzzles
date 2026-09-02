class Solution {
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
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
        for (String s : words) {
            Node curr = root;
            for (char c : s.toCharArray()) {
                curr.children.putIfAbsent(c, new Node());
                curr = curr.children.get(c);
            }
            curr.isEnd = true;
        }
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(root, i, j, board, visited, result, "");
            }
        }
        return result;
    }

    public void dfs(Node curr, int row, int col, char[][] board, boolean visited[][], List<String> result, String s) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || !curr.children.containsKey(board[row][col])) {
            return;
        }

        visited[row][col] = true;
        curr = curr.children.get(board[row][col]);
        s += board[row][col];
        if (curr.isEnd) {
            result.add(s);
            curr.isEnd = false;
        }
        dfs(curr, row + 1, col, board, visited, result, s);
        dfs(curr, row, col + 1, board, visited, result, s);
        dfs(curr, row - 1, col, board, visited, result, s);
        dfs(curr, row, col - 1, board, visited, result, s);
        visited[row][col] = false;
    }
}
