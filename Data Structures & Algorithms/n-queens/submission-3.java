class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), result, n);
        return result;
    }

    public void backtrack(List<String> curr, int row, HashSet<Integer> cols, HashSet<Integer> pos, HashSet<Integer> neg, List<List<String>> result, int n) {
        if (curr.size() == n) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!cols.contains(i) && !pos.contains(row + i) && !neg.contains(row - i)) {
                String board = "";
                for (int j = 0; j < n; j++) {
                    if (j == i) {
                        board += "Q";
                    } else {
                        board += ".";
                    }
                }
                curr.add(board);
                cols.add(i);
                pos.add(row + i);
                neg.add(row - i);
                backtrack(curr, row + 1, cols, pos, neg, result, n);
                curr.remove(board);
                cols.remove(i);
                pos.remove(row + i);
                neg.remove(row - i);
            }
        }


    }
}
