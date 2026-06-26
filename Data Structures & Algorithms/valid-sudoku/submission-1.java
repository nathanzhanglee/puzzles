class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (row.contains(board[i][j]) && board[i][j] != '.'){
                    return false;
                }
                row.add(board[i][j]);
            }
        }

        for (int i = 0; i < 9; i++) {
            HashSet<Character> col = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (col.contains(board[j][i]) && board[j][i] != '.') {
                    return false;
                }
                col.add(board[j][i]);
            }
        }

        HashMap<Integer, HashSet<Character>> m = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            m.put(i, new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int row = i / 3;
                int col = j / 3;
                int box = row * 3 + col;
                if (m.get(box).contains(board[i][j]) && board[i][j] != '.') {
                    return false;
                }
                m.get(box).add(board[i][j]);
            }
        }
        return true;
    }
}
