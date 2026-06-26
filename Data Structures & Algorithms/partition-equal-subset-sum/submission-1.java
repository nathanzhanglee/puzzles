class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }    
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for (int n : nums) {
            for (int i = half; i >= 0; i--) {
                if (i - n >= 0 && dp[i - n]) {
                    dp[i] = true;
                }
            }
        }
        return dp[half];
    }
}
