class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    public void dfs(int[] nums, boolean[] visited, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                curr.add(nums[i]);
                dfs(nums, visited, curr, res);
                visited[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }
}
