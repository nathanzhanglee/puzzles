class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[nums[0]];
        int slow = nums[0];
        while (slow != fast) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        int slow2 = 0;
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow;
    }
}
