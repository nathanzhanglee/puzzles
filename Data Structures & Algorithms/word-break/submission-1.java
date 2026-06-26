class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length() + 1; i++) {
            if (!dp[i]) {
                continue;
            }
            for (String word : wordDict) {
                if (i + word.length() <= s.length() && word.equals(s.substring(i, i + word.length()))) {
                    dp[i + word.length()] = true;
                }     
            }
        }
        return dp[s.length()];
    }
}
