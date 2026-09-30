class Solution {
    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int res = Integer.MIN_VALUE;
        for (int n : nums) {
            int temp = max * n;
            max = Math.max(Math.max(n, temp), min * n);
            min = Math.min(Math.min(n, temp), min * n);
            res = Math.max(res, max);
        }
        return res;
    }
}
