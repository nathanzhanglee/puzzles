class Solution {
    public int maxProfit(int[] prices) {
        int minBought = Integer.MAX_VALUE;
        int maxProf = Integer.MIN_VALUE;
        for (int n : prices) {
            minBought = Math.min(minBought, n);
            maxProf = Math.max(maxProf, n - minBought);
        }
        return maxProf;
    }
}
