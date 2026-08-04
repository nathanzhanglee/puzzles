class Solution {
    int directions[][] = new int[][] {{0, 1}, {1, 0}, {-1,0}, {0,-1}};
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited[i][j] && board[i][j] == 'O' && surrounded(board, i, j, visited)) {
                    dfs(board, i, j);
                }
            }
        } 
    }

    public boolean surrounded(char[][] board, int i , int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == 'X' || visited[i][j]) {
            return true;
        }
        visited[i][j] = true;
        for (int[] direction : directions) {
            if (!surrounded(board, i + direction[0], j + direction[1], visited)) {
                return false;
            }
        }
        return true;
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'X';
        for (int[] direction : directions) {
            dfs(board, i + direction[0], j + direction[1]);
        }
    }
}
