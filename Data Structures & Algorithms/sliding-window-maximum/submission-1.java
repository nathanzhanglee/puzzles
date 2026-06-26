class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> maxes = new ArrayList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            while (maxes.size() != 0 && maxes.get(maxes.size() - 1) < curr) {
                maxes.remove(maxes.size() - 1);
            }
            maxes.add(curr);
            if (i >= k - 1) {
                res[i - (k - 1)] = maxes.get(0);
                if (nums[i - (k - 1)] == maxes.get(0)) {
                    maxes.remove(0);
                }
            }
        }
        return res;
    }
}
