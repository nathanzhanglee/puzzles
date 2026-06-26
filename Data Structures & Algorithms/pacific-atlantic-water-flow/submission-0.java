class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            pacific[i][0] = true;
            bfs(heights, i, 0, pacific);
        }
        for (int j = 0; j < heights[0].length; j++) {
            pacific[0][j] = true;
            bfs(heights, 0, j, pacific);
        }
        for (int i = 0; i < heights.length; i++) {
            atlantic[i][heights[0].length - 1] = true;
            bfs(heights, i, heights[0].length - 1, atlantic);
        }
        for (int j = 0; j < heights[0].length; j++) {
            atlantic[heights.length - 1][j] = true;
            bfs(heights, heights.length - 1, j, atlantic);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> coord = new ArrayList<>();
                    coord.add(i);
                    coord.add(j);
                    res.add(coord);
                }
            }
        }
        return res;
    }
    public void bfs(int[][] heights, int i, int j, boolean[][] ocean) {
        int[][] directions = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();
                for (int[] direction : directions) {
                    int y = direction[0] + curr[0];
                    int x = direction[1] + curr[1];
                    if (y >= 0 && x >= 0 && y < heights.length && x < heights[0].length && heights[y][x] >= heights[curr[0]][curr[1]] && !ocean[y][x]) {
                        ocean[y][x] = true;
                        q.add(new int[] {y, x});
                    }
                }
            }
        }
    }
}
