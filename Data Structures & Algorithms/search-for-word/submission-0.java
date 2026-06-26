class Solution {
    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        char first = word.charAt(0);
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == first) {
                    visited[i][j] = true;
                    if (dfs(board, 1, visited, i, j, word)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int index, boolean[][] visited, int i, int j, String word) {
        if (index == word.length()) {
            return true;
        }
        char next = word.charAt(index);
        for (int[] direction : directions) {
            int y = direction[0] + i;
            int x = direction[1] + j;
            if (y >= 0 && x >= 0 && y < board.length && x < board[0].length && board[y][x] == next && visited[y][x] == false) {
                visited[y][x] = true;
                if (dfs(board, index + 1, visited, y, x, word)) {
                    return true;
                }
                visited[y][x] = false;
            }
        }
        return false;
    }
}

