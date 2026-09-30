class Solution {
    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int res = 0;
        for (int n : nums) {
            int temp = max * n;
            max = Math.max(Math.max(temp, min * n), n);
            min = Math.min(Math.min(temp, min * n), n);
            res = Math.max(res, max);
        }
        return res;
    }
}
