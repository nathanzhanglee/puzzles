class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // Only process unvisited 'O' cells
                if (!visited[i][j] && board[i][j] == 'O') {
                    // Check if this connected component is surrounded
                    if (surrounded(board, i, j, visited)) {
                        // If surrounded, flip all 'O's in this component to 'X'
                        flipToX(board, i, j);
                    }
                    // If not surrounded, the visited markings remain but we don't flip
                }
            }
        }
    }
    
    /**
     * Checks if the connected component of 'O's starting at (i,j) is completely surrounded.
     * Marks all visited nodes in the component.
     * Returns false if any 'O' in the component touches the boundary.
     */
    public boolean surrounded(char[][] board, int i, int j, boolean[][] visited) {
        // Boundary check - if we reach boundary with an 'O', not surrounded
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        
        // If we hit 'X' or already visited, this path is fine
        if (board[i][j] == 'X' || visited[i][j]) {
            return true;
        }
        
        // Mark current cell as visited
        visited[i][j] = true;
        
        // Explore all 4 directions
        for (int[] direction : directions) {
            if (!surrounded(board, i + direction[0], j + direction[1], visited)) {
                return false; // Found a path to boundary
            }
        }
        
        return true; // All paths from this component stay within boundaries
    }
    
    /**
     * Flips all 'O's connected to (i,j) to 'X'.
     * This is called only when we know the component is surrounded.
     */
    public void flipToX(char[][] board, int i, int j) {
        // Boundary check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        
        // Only flip 'O' cells
        if (board[i][j] != 'O') {
            return;
        }
        
        // Flip current cell
        board[i][j] = 'X';
        
        // Recursively flip connected 'O' cells
        for (int[] direction : directions) {
            flipToX(board, i + direction[0], j + direction[1]);
        }
    }
}
