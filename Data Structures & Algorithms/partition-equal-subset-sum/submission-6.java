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
        for (int n : nums) {
            if (n > half) {
                return false;
            }
            dp[n] = true;
        }
        for (int n : nums) {
            if (half == n || dp[half - n]) {
                return true;
            }
        }
        return false;
    }
}
