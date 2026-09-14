class Solution {
    public int rob(int[] nums) {
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
        }
        return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
    }
}
