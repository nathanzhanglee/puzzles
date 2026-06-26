class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        helper(n, new ArrayList<>(), 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), res);
        return res;
    }

    public void helper(int n, List<String> curr, int row, HashSet<Integer> cols, 
                        HashSet<Integer> posDiagonals, HashSet<Integer> negDiagonals, 
                        List<List<String>> res) {

        if (row == n) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!cols.contains(i) && !posDiagonals.contains(i + row) && !negDiagonals.contains(i - row)) {
                String newRow = "";
                for (int j = 0; j < n; j++) {
                    if (j == i) {
                        newRow += "Q";
                    } else {
                        newRow += ".";
                    }
                }
                curr.add(newRow);
                cols.add(i);
                posDiagonals.add(i + row);
                negDiagonals.add(i - row);
                helper(n, curr, row + 1, cols, posDiagonals, negDiagonals, res);
                curr.remove(curr.size() - 1);
                cols.remove(i);
                posDiagonals.remove(i + row);
                negDiagonals.remove(i - row);
            }
        }
    }

}
