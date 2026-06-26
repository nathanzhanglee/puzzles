class Solution {
    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        for (int[] direction : directions) {
            int y = i + direction[0];
            int x = j + direction[1];
            if (y >= 0 && x >= 0 && y < grid.length && x < grid[0].length && grid[y][x] == '1') {
                grid[y][x] = '0';
                dfs(grid, y, x);
            }
        }
    }
}
