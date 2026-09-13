class Solution {
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            dfs(i, 0, board);
            dfs(i, board[0].length - 1, board);
        }
        for (int j = 0; j < board[0].length; j++) {
            dfs(0, j, board);
            dfs(board.length - 1, j, board);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int row, int col, char[][] board) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') {
            return;
        } 
        board[row][col] = 'T';
        dfs(row - 1, col, board);
        dfs(row, col - 1, board);
        dfs(row + 1, col, board);
        dfs(row, col + 1, board);
    }
}
