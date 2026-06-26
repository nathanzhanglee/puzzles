class Solution {
    public int maxProfit(int[] prices) {
        int minBought = Integer.MAX_VALUE;
        int maxProf = Integer.MIN_VALUE;
        for (int n : prices) {
            maxProf = Math.max(maxProf, n - minBought);
            minBought = Math.min(minBought, n);
        }
        return Math.max(0, maxProf);
    }
}
