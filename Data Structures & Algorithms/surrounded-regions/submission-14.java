

public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        
        int m = board.length;
        int n = board[0].length;
        
        // Visited array to track which 'O' has been processed
        boolean[][] visited = new boolean[m][n];
        
        // Directions for BFS (right, left, down, up)
        int[] dirX = {1, -1, 0, 0};
        int[] dirY = {0, 0, 1, -1};
        
        // Perform BFS to mark all the 'O's connected to the borders
        for (int i = 0; i < m; i++) {
            for (int j : new int[]{0, n - 1}) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    bfs(board, i, j, visited, dirX, dirY);
                }
            }
        }
        
        for (int j = 0; j < n; j++) {
            for (int i : new int[]{0, m - 1}) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    bfs(board, i, j, visited, dirX, dirY);
                }
            }
        }
        
        // Flip 'O' to 'X' for all unvisited 'O's
        // Flip 'A' to 'O' for all the 'O's that are safe (connected to border)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X'; // Flip to X if it's surrounded
                } else if (board[i][j] == 'O' && visited[i][j]) {
                    board[i][j] = 'O'; // Keep 'O' if it's not surrounded
                }
            }
        }
    }

    private void bfs(char[][] board, int startX, int startY, boolean[][] visited, int[] dirX, int[] dirY) {
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];
            
            // Check all 4 directions (right, left, down, up)
            for (int i = 0; i < 4; i++) {
                int newX = x + dirX[i];
                int newY = y + dirY[i];
                
                // Skip if out of bounds or already visited
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY] || board[newX][newY] != 'O') {
                    continue;
                }
                
                // Mark as visited and add to queue
                visited[newX][newY] = true;
                queue.offer(new int[]{newX, newY});
            }
        }
    }
}
