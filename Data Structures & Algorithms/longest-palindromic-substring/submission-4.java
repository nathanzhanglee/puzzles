class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j <= s.length() - 1; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i + 1<= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > max) {
                        left = i;
                        right = j;
                        max = j - i + 1;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
