class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, candidates, target, 0, result);
        return result;
    }

    public void backtrack(List<Integer> curr, int index, int[] candidates, int target, int sum, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }
        if (index == candidates.length || sum > target) {
            return;
        }
        curr.add(candidates[index]);
        backtrack(curr, index + 1, candidates, target, sum + candidates[index], result);
        curr.remove(curr.size() - 1);
        index++;
        while (index < candidates.length && candidates[index] == candidates[index - 1]) {
            index++;
        }
        backtrack(curr, index, candidates, target, sum, result);
    }
}
