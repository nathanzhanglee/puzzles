class Solution {
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            pacific[i][0] = true;
            dfs(i, 0, heights, pacific);
        }
        for (int i = 0; i < heights[0].length; i++) {
            pacific[0][i] = true;
            dfs(0, i, heights, pacific);
        }
        for (int i = 0; i < heights.length; i++) {
            atlantic[i][heights[0].length - 1] = true;
            dfs(i, heights[0].length - 1, heights, atlantic);
        }
        for (int i = 0; i < heights[0].length; i++) {
            atlantic[heights.length - 1][i] = true;
            dfs(heights.length - 1, i, heights, atlantic);
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

    public void dfs(int row, int col, int[][] heights, boolean[][] ocean) {
        for (int[] direction : directions) {
            int y = row + direction[0];
            int x = col + direction[1];
            if (y >= 0 && x >= 0 && y < heights.length && x < heights[0].length && !ocean[y][x] && heights[row][col] < heights[y][x]) {
                ocean[y][x] = true;
                dfs(y, x, heights, ocean);
            }
        }
    }
}
