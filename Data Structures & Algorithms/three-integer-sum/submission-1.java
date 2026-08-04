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
                } else if (nums[left] + nums[right] < need) {
                    left++;
                    while (left + 1 < nums.length && nums[left] != nums[left - 1]) {
                        left++;
                    }
                } else {
                    right--;
                    while (right - 1 >= 0 && nums[right] != nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
