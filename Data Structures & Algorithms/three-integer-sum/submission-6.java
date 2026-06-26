class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int curr = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + curr == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[left], nums[right], curr)));
                    left++; 
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] + curr < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
