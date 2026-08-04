class Solution {
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i =0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        int days = 0;
        int infected = 0;
        while (!queue.isEmpty()) {
            days++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                for (int[] direction : directions) {
                    int y = rotten[0] + direction[0];
                    int x = rotten[1] + direction[1];
                    if (y >= 0 && x >= 0 && y < grid.length && x < grid[0].length && grid[y][x] == 1) {
                        grid[y][x] = -1;
                        infected++;
                        queue.add(new int[] {y, x});
                    }
                }
            }
            if (infected == fresh) {
                return days;
            }
        }
        return fresh == 0 ? 0 : -1;
    }
}
