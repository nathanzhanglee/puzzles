class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, 0, new ArrayList<>(), res);
        return res;
    }

    public void dfs(int[] candidates, int target, int sum, int index, List<Integer> curr, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (index == candidates.length || sum > target) {
            return;
        }
        curr.add(candidates[index]);
        dfs(candidates, target, sum + candidates[index], index + 1, curr, res);
        curr.remove(curr.size() - 1);
        index++;
        while (index < candidates.length && candidates[index] == candidates[index - 1]) {
            index++;
        }
        dfs(candidates, target, sum, index, curr, res);
    }
}
