class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }
    public void dfs(int[] nums, int index, List<Integer> curr, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        dfs(nums, index + 1, curr, res);
        curr.remove(curr.size() - 1);
        dfs(nums, index + 1, curr, res);
    }
}
