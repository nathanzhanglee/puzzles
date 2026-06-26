class Solution {
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (int k = 0; k < words.length; k++) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (k >= words.length) {
                        return res;
                    }
                    String s = words[k];
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (board[i][j] == s.charAt(0)) {
                        visited[i][j] = true;
                        if (dfs(board, s, i, j, 1, visited)) {
                            res.add(s);
                            k++; 
                            i = -1;
                            j = 0;
                            break;
                        }
                        visited[i][j] = false;
                    }
                }
            }
        }
        return res;
    }

    public boolean dfs(char[][] board, String s, int i, int j, int index, boolean[][] visited) {
        if (index == s.length()) {
            return true;
        }

        char c = s.charAt(index);
        for (int[] direction : directions) {
            int y = direction[0] + i;
            int x = direction[1] + j;
            if (y >= 0 && x >= 0 && y < board.length && x < board[0].length 
            && board[y][x] == c && !visited[y][x]) {
                visited[y][x] = true;
                if (dfs(board, s, y, x, index + 1, visited)) {
                    return true;
                };
                visited[y][x] = false;
            }
        }
        return false;
    }
}
