class Solution {
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    res = Math.max(res, dfs(grid, i, j, 1));
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j, int area) {
        for (int[] direction : directions) {
            int y = i + direction[0];
            int x = j + direction[1];
            if (y >= 0 && x >= 0 && y < grid.length && x < grid[0].length && grid[y][x] == 1) {
                grid[y][x] = 0;
                area = dfs(grid, y, x, area + 1);
            }
        }
        return area;
    }
}
