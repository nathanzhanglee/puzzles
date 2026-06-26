class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    public void backtrack(List<String> res, String curr, int forward, int backward, int n) {
        if (curr.length() == 2 * n) {
            res.add(curr);
        }
        if (backward > forward) {
            return;
        }
        if (forward < n) {
            backtrack(res, curr + "(", forward + 1, backward, n);
        }
        if (forward > backward) {
            backtrack(res, curr + ")", forward, backward + 1, n);
        }
    }
}
