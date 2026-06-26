class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        backtrack(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), new ArrayList<>(), res);
        return res;
    }
    public void backtrack(int n, int row, HashSet<Integer> cols, HashSet<Integer> pos, HashSet<Integer> neg, List<String> curr, List<List<String>> res) {
        if (row == n) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!cols.contains(i) && !pos.contains(row + i) && !neg.contains(row - i)) {
                cols.add(i);
                pos.add(row + i);
                neg.add(row - i);
                String s = "";
                for (int j = 0; j < n; j++) {
                    if (j == i) {
                        s += "Q";
                    } else {
                        s += ".";
                    }
                }
                curr.add(s);
                backtrack(n, row + 1, cols, pos, neg, curr, res);
                curr.remove(curr.size() - 1);
                cols.remove(i);
                pos.remove(row + i);
                neg.remove(row - i);
            }
        }
    }
}
