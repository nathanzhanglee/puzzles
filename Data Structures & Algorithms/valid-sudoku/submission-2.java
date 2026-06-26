class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        HashMap<Integer, HashSet<Character>> boxes = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            cols.put(i, new HashSet<>());
            boxes.put(i, new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char curr = board[i][j];
                if (curr != '.') {
                    if (row.contains(curr)) {
                        return false;
                    } else {
                        row.add(curr);
                    }
                    if (cols.get(j).contains(curr)) {
                        return false;
                    } else {
                        cols.get(j).add(curr);
                    }
                    int box = (i / 3) * 3 + (j / 3); 
                    if (boxes.get(box).contains(curr)) {
                        return false;
                    } else {
                        boxes.get(box).add(curr);
                    }
                }
            }
        }
        return true;
    }
}
