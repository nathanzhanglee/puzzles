class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> l = new ArrayList<>();
        int[] result = new int[nums.length + 1 - k];
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            int n = nums[right];
            while (!l.isEmpty() && l.get(l.size() - 1) < n) {
                l.remove(l.size() - 1);
            }
            l.add(n);
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
