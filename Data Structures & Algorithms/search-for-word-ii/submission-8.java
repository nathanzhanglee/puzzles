class Solution {
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (String word : words) {
            if (dfs(0, 0, 0, board, visited, word)) {
                result.add(word);
            }
        }
        return result;
    }

    public boolean dfs(int index, int row, int col, char[][] board, boolean[][] visited, String word) {
        if (index == word.length()) {
            return true;
        }
        if (index == 0) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(index)) {
                        visited[i][j] = true;
                        if (dfs(index + 1, i, j, board, visited, word)) {
                            visited[i][j] = false;
                            return true;
                        }
                        visited[i][j] = false;
                    }
                }
            }
        } else {
            for (int[] direction : directions) {
                int y = row + direction[0];
                int x = col + direction[1];
                if (y >= 0 && y < board.length && x >= 0 && x < board[0].length && !visited[y][x] && board[y][x] == word.charAt(index)) {
                    visited[y][x] = true;
                    if (dfs(index + 1, y, x, board, visited, word)) {
                        visited[y][x] = false;
                        return true;
                    }
                    visited[y][x] = false;                
                }
            }
        }
        return false;
    }
}
