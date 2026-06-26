class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, target, 0, 0, new ArrayList<>(), res);
        return res;
    }

    public void dfs(int[] nums, int target, int sum, int index, List<Integer> curr, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (sum > target || index == nums.length) {
            return;
        }
        curr.add(nums[index]);
        dfs(nums, target, sum + nums[index], index, curr, res);
        curr.remove(curr.size() - 1);
        dfs(nums, target, sum, index + 1, curr, res);
    }
}
