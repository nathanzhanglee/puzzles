class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                i++;
                if (i >= nums.length) {
                    return result;
                }
            } 
            int curr = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + curr == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[left], nums[right], curr)));
                    left++; 
                    right--;
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
