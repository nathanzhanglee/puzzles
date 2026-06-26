class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = Integer.MIN_VALUE;
        int index = -1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i + 1 <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        index = i;
                    }
                }           
            }
        }
        return s.substring(index, index + maxLength);
    }
}
