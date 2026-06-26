class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    result.add(triplet);
                    left++; 
                    right--;
                    while (left < right && nums[left] == nums [left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums [right + 1]) {
                        right--;
                    }                
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
            i++;
            while (i < nums.length - 2 && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return result;
    }
}
