class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            fast = (fast + 2) % nums.length;
            slow = (slow + 1) % nums.length;
            if (nums[slow] == nums[fast]) {
                return nums[slow];
            }
        }
    }
}
