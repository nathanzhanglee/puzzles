class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> l = new ArrayList<>();
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            while (!l.isEmpty() && l.get(l.size() - 1) < nums[right]) {
                l.remove(l.size() - 1);
            }
            l.add(nums[right]);
            if (right - left + 1 == k) {
                res[left] = l.get(0);
                if (l.get(0) == nums[left]) {
                    l.remove(0);
                }
                left++;
            }
            right++;
        }
        return res;
    }
}
