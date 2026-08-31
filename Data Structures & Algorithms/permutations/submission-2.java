class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(new ArrayList<>(), nums, result, visited);
        return result;
    }

    public void backtrack(List<Integer> curr, int[] nums, List<List<Integer>> result, boolean[] visited) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                curr.add(nums[i]);
                visited[i] = true;
                backtrack(curr, nums, result, visited);
                curr.remove(curr.size() - 1);
                visited[i] = false;
            }
        }
    }
}
