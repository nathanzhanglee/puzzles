class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, target, 0, 0, new ArrayList<>(), res);
        return res;
    }

    public void dfs(int[] nums, int target, int index, int sum, List<Integer> curr, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (index >= nums.length || sum > target) {
            return;
        }
        curr.add(nums[index]);
        dfs(nums, target, index, sum + nums[index], curr, res);
        curr.remove(curr.size() - 1);
        dfs(nums, target, index + 1, sum, curr, res);
    }
}
