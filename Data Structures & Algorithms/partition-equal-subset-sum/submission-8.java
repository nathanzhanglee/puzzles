class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean[] dp = new boolean[(sum / 2) + 1];
        dp[0] = true;
        for (int n : nums) {
            for (int i = dp.length - 1; i >= n; i--) {
                if (dp[i - n]) {
                    dp[i] = true;
                }
            }
        }
        return dp[sum / 2];
    }
}
