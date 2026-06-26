class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                int LIS = dp[i + 1][j + 1];
                if (j == - 1 || nums[j] < nums[i]) {
                    LIS = Math.max(LIS, 1 + dp[i + 1][i + 1]);
                }
                dp[i][j + 1] = LIS;
            }
        }
        return dp[0][0];
    }
}
