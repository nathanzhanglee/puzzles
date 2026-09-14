class Solution {
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        nums[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
        }
        return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
    }
}
