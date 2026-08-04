class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        boolean start = true;
        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            if (!start && fast == slow) {
                return fast;
            }
            fast = nums[fast];
            if (fast == slow) {
                return fast;
            }
            start = false;
        }
    }
}
