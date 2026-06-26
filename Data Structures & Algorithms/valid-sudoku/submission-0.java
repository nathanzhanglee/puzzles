class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> seen = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (seen.contains(board[i][j])) {
                    return false;
                }
                if (board[i][j] != '.') {
                    seen.add(board[i][j]);
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            HashSet<Character> seen = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (seen.contains(board[j][i])) {
                    return false;
                }
                if (board[j][i] != '.') {
                    seen.add(board[j][i]);
                }
            }
        }     

        // check boxes
        HashMap<Integer, HashSet<Character>> boxes = new HashMap<>();
        for (int z = 0; z < 9; z++) {
            boxes.put(z, new HashSet<>());
        }

        for (int m = 0; m < 9; m++) {
            for (int n = 0; n < 9; n++) {
                int row = m / 3;
                int col = n / 3;
                if (boxes.get((row * 3) + col).contains(board[m][n])) {
                    return false;
                }
                if (board[m][n] != '.') {
                    boxes.get((row * 3) + col).add(board[m][n]);
                }
            }
        }
        return true;
    }
}
