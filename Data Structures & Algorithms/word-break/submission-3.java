class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        for (int i = s.length(); i >= 0; i--) {
            for (String word : wordDict) {
                if (i + word.length() <= s.length() && word.equals(s.substring(i, i + word.length()))) {
                    dp[i] = true;
                    break;
                }     
            }
        }
        return dp[0];
    }
}
