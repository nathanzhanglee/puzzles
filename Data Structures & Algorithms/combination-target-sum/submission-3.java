class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, nums, target, result, 0);
        return result;
    }

    public void backtrack(List<Integer> curr, int index, int[] nums, int target, List<List<Integer>> result, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }
        if (index == nums.length || sum > target) {
            return;
        }
        curr.add(nums[index]);
        backtrack(curr, index, nums, target, result, sum + nums[index]);
        curr.remove(curr.size() - 1);
        backtrack(curr, index + 1, nums, target, result, sum);
    }
}
