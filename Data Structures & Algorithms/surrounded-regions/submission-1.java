class Solution {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    dfs(board, i, j, visited);
                }
            }
        } 
    }

    public boolean dfs(char[][] board, int i , int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return true;
        }
        if (board[i][j] == 'X') {
            return false;
        }
        board[i][j] = 'X';
        visited[i][j] = true;
        if (dfs(board, i - 1, j, visited) || dfs(board, i + 1, j, visited) || dfs(board, i, j - 1, visited) || dfs(board, i , j + 1, visited)) {
            board[i][j] = 'O';
        }
        return false;
    }
}
