class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> dq = new ArrayList<>();
        int left = 0;
        int right = 0;
        int[] result = new int[nums.length - k + 1];
        while (right < nums.length) {
            while (!dq.isEmpty() && dq.get(dq.size() - 1) < nums[right]) {
                dq.remove(dq.size() - 1);
            }
            dq.add(nums[right]);
            if (right - left + 1 == k) {
                result[left] = dq.get(0);
                if (dq.get(0) == nums[left]) {
                    dq.remove(0);
                }
                left++;
            }
            right++;
        }
        return result;
    }
}
