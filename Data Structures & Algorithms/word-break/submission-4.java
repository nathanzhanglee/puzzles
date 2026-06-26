class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length(); i >= 0; i--) {
            for (String word : wordDict) {
                if (word.length() + i <= s.length() && dp[i + word.length()] && word.equals(s.substring(i, i + word.length()))) {
                    dp[i] = true;
                    break;
                }     
            }
        }
        return dp[0];
    }
}
