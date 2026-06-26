class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    // Use separate visited array for this component check
                    boolean[][] componentVisited = new boolean[board.length][board[0].length];
                    
                    if (surrounded(board, i, j, componentVisited)) {
                        // If surrounded, flip all cells in this component to 'X'
                        flipComponent(board, componentVisited);
                    }
                    
                    // Mark all cells in this component as visited in main array
                    markMainVisited(visited, componentVisited);
                }
            }
        }
    }
    
    /**
     * Checks if the connected component starting at (i,j) is surrounded.
     * Marks all visited cells in componentVisited array.
     * Returns false if any 'O' cell in the component touches boundary.
     */
    public boolean surrounded(char[][] board, int i, int j, boolean[][] componentVisited) {
        // If we go out of bounds, the component touches boundary - not surrounded
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        
        // If we hit 'X' or already visited cell, this path is fine
        if (board[i][j] == 'X' || componentVisited[i][j]) {
            return true;
        }
        
        // Mark current 'O' cell as visited
        componentVisited[i][j] = true;
        
        // Check all 4 directions - if any path leads to boundary, not surrounded
        for (int[] direction : directions) {
            if (!surrounded(board, i + direction[0], j + direction[1], componentVisited)) {
                return false;
            }
        }
        
        return true; // All paths stay within boundaries
    }
    
    /**
     * Flips all 'O' cells marked in componentVisited to 'X'
     */
    private void flipComponent(char[][] board, boolean[][] componentVisited) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (componentVisited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    /**
     * Copies visited markings from component check to main visited array
     */
    private void markMainVisited(boolean[][] visited, boolean[][] componentVisited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (componentVisited[i][j]) {
                    visited[i][j] = true;
                }
            }
        }
    }
}