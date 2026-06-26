class Solution {
    int[][] directions = new int[][] {{0,1}, {0,-1}, {-1,0}, {1,0}};
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
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

    public void dfs(char[][] board, int i, int j) {
        if (i >= 0 && j >= 0 && i < board.length && j < board[0].length && board[i][j] == 'O') {
            board[i][j] = 'T';
            for (int[] direction : directions) {
                dfs(board, i + direction[0], j + direction[1]);
            }
        }
    }
}
