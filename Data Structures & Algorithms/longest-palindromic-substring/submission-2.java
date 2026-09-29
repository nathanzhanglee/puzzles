class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int n = s.length();
        int start = 0;
        int end = 0;
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && 
                (j - i <=  2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > max) {
                        start = i;
                        end = j;
                        max = j - i + 1;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
