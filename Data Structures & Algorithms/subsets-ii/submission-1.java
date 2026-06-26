class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
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
        index++;
        while (index < nums.length && nums[index] == nums[index - 1]) {
            index++;
        }
        dfs(nums, index, curr, res);
    }
}
