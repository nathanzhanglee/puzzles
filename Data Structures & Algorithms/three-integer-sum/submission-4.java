class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (i != 0 && nums[i - 1] == curr) {
                continue;
            }
            int need = 0 - curr;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == need) {
                    res.add(new ArrayList<>(Arrays.asList(curr, nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < need) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
