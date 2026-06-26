class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) { // sources added to queue (rotten fruits)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
            }
        }
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] direction : directions) {
                    int y = direction[0] + curr[0];
                    int x = direction[1] + curr[1];
                    if (y >= 0 && x >= 0 && y < grid.length && x < grid[0].length && grid[y][x] == 1) {
                        grid[y][x] = 2;
                        q.add(new int[] {y, x});
                    }
                }
            }
            if (q.isEmpty()) {
                break;
            }
            time++;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }
}
