class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = 0;
        ArrayList<Integer> l = new ArrayList<>();
        int[] result = new int[nums.length - k + 1];
        while (right < nums.length) {
            while (l.size() != 0 && nums[right] > l.get(l.size() - 1)) {
                l.remove(l.size() - 1);
            }
            l.add(nums[right]);
            if (right - left + 1 == k) {
                result[left] = l.get(0);
                if (l.get(0) == nums[left]) {
                    l.remove(0);
                }
                left++;
            }
            right++;
        }
        return result;
    }
}
