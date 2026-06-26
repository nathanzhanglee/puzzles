class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int max = 1;
        int min = 1;

        for (int n : nums) {
            int temp = n * max;
            max = Math.max(Math.max(temp, n * min), n);
            min = Math.min(Math.min(temp, n * min), n);
            res = Math.max(res, max);
        }
        return res;
    }
}
