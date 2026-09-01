class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack("(", 1, 0, result, n);
        return result;
    }
    public void backtrack(String curr, int open, int closed, List<String> result, int n) {
        if (open == n && closed == n) {
            result.add(curr);
            return;
        }
        if (open < n) {
            backtrack(curr + "(", open + 1, closed, result, n);
        }
        if (closed < n && closed < open) {
            backtrack(curr + ")", open, closed + 1, result, n);
        }
    }
}
