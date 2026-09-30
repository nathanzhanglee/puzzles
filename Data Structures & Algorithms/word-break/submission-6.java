class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String curr : wordDict) {
                if (i + curr.length() <= s.length() && s.substring(i, i + curr.length()).equals(curr)) {
                    dp[i] = dp[i + curr.length()];
                }
            }
        }
        return dp[0];
    }
}
