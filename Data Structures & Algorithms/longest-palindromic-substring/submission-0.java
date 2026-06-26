class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = -1;
        int max = Integer.MIN_VALUE;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i + 1 <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (max < j - i + 1) {
                        start = i;
                        max = j - i + 1;
                    }
                }
            }
        }
        return s.substring(start, start + max);
    }
}
