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

public boolean surrounded(char[][] board, int i, int j, boolean[][] visited) {
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
        return false;  // Should return false if it touches the boundary.
    }
    if (board[i][j] == 'X' || visited[i][j]) {
        return true;  // Only 'X' cells and already visited cells can be considered part of the "surrounded" region.
    }
    visited[i][j] = true;
    for (int[] direction : directions) {
        if (!surrounded(board, i + direction[0], j + direction[1], visited)) {
            return false;  // If any direction is not surrounded, return false.
        }
    }
    return true;  // If all directions are surrounded, return true.
}

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X') {
            return;
        }
        board[i][j] = 'X';
        for (int[] direction : directions) {
            dfs(board, i + direction[0], j + direction[1]);
        }
    }
}
