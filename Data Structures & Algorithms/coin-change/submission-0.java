class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        
        for (int i = 0; i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            }
        }
        for (int i = 0; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] > 0 && dp[i - coins[j]] != Integer.MAX_VALUE && 1 + dp[i - coins[j]] < dp[i]) {
                    dp[i] = 1 + dp[i - coins[j]];
                }
            }
        }
        return (dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount]);
    }
}
