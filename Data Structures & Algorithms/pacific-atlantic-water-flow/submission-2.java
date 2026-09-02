class Solution {
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        
        for (int i = 0; i < heights.length; i++) {
            pacific[i][0] = true;
            bfs(i, 0, pacific, heights);
        }
        for (int i = 0; i < heights[0].length; i++) {
            pacific[0][i] = true;
            bfs(0, i, pacific, heights);
        }
        for (int i = 0; i < heights.length; i++) {
            atlantic[i][heights[0].length - 1] = true;
            bfs(i, heights[0].length - 1, atlantic, heights);
        }
        for (int i = 0; i < heights[0].length; i++) {
            atlantic[heights.length - 1][i] = true;
            bfs(heights.length - 1, i, atlantic, heights);
        }
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(i);
                    curr.add(j);
                    result.add(curr);
                }
            }
        }
        return result;
    }

    public void bfs(int row, int col, boolean[][] ocean, int[][] heights) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {row, col});
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
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
