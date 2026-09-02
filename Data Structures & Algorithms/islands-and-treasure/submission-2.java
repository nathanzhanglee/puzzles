class Solution {
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<int[]>();
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
                for (int[] direction : directions) {
                    int y = curr[0] + direction[0];
                    int x = curr[1] + direction[1];
                    if (y >= 0 && y < grid.length && x >= 0 && x < grid[0].length && grid[y][x] > dist) {
                        grid[y][x] = dist;
                        q.add(new int[] {y, x});
                    }
                }
            }
            dist++;
        }
    }

}
