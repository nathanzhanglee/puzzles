class Solution {
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        boolean[][] discovered = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    discovered[i][j] = true;
                    if (dfs(i, j, discovered, board, 1, word)) {
                        return true;
                    }
                    discovered[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean dfs(int row, int col, boolean[][] discovered, char[][] board, int index, String word) {
        if (index == word.length()) {
            return true;
        }
        for (int[] direction : directions) {
            int y = row + direction[0];
            int x = col + direction[1];
            if (y >= 0 && y < board.length && x >= 0 && x < board[0].length && !discovered[y][x] && board[y][x] == word.charAt(index)) {
                discovered[y][x] = true;
                if (dfs(y, x, discovered, board, index + 1, word)) {
                    return true;
                }
                discovered[y][x] = false;
            }
        }
        return false;
    }


}
