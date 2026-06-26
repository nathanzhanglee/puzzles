class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, 0, 0, n, "");
        return res;
    }

    public void backtrack(List<String> res, int forward, int backward, int n, String curr) {
        if (forward == n && backward == n) {
            res.add(curr);
            return;
        }
        if (forward < n) {
            backtrack(res, forward + 1, backward, n, curr + "(");
        }
        if (forward > backward) {
            backtrack(res, forward, backward + 1, n, curr + ")");
        }
    }
}
