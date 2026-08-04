class Solution {
    int directions[][] = new int[][] {{0, 1}, {1, 0}, {-1,0}, {0,-1}};
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
        boolean edge = false;
        for (int[] direction : directions) {
            if (dfs(board, i + direction[0], j + direction[1], visited)) {
                edge = true;
            }
        }
        if (edge) {
            board[i][j] = 'O';
        }
        return edge;
    }
}
