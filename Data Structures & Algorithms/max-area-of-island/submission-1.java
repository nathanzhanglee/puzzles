class Solution {
    int size = 0;
    int result = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid);
                    result = Math.max(size, result);
                    size = 0;
                }
            }
        }
        return result;
    }

    public void dfs(int row, int col, int[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) {
            return;
        }
        grid[row][col] = 0;
        size++;
        dfs(row - 1, col, grid);
        dfs(row + 1, col, grid);
        dfs(row, col + 1, grid);
        dfs(row, col - 1, grid);
    }
}
