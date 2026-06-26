class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    public void dfs(int[] nums, int size, boolean[] visited, List<Integer> curr, List<List<Integer>> res) {
        if (size == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                curr.add(nums[i]);
                visited[i] = true;
                dfs(nums, size + 1, visited, curr, res);
                curr.remove(curr.size() - 1);
                visited[i] = false;
            }
        }
    }
}
