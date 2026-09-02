class Solution {
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[] {i, j});
                }
            }
        }
        int dist = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] direction: directions) {
                    int y = direction[0] + curr[0];
                    int x = direction[1] + curr[1];
                    if (y >= 0 && x >= 0 && y < grid.length && x < grid[0].length && grid[y][x] > dist) {
                        grid[y][x] = dist;
                        q.add(new int[] {y, x});
                    }
                }
            }
            dist++;
        }
    }
}
