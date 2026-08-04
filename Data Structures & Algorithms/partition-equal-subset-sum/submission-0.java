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
        dp[half] = true;
        for (int i = half; i >= 0; i--) {
            for (int n : nums) {
                if (i + n <= half && dp[i + n]) {
                    dp[i] = true;
                }
            }
        }
        return dp[0];
    }
}
