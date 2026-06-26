class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valuesToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (valuesToIndex.containsKey(target - nums[i])) {
                return new int[] {valuesToIndex.get(target - nums[i]), i};
            }
            valuesToIndex.put(nums[i], i);
        }
        return new int[]{};
    }
}
