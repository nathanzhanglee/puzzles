class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, 0, target, candidates, result);
        return result;
    }
    public void backtrack(List<Integer> curr, int index, int sum, int target, int[] candidates, List<List<Integer>> result) {
        if (target == sum) {
            result.add(new ArrayList<>(curr));
            return;
        } 
        if (sum > target || index == candidates.length) {
            return;
        }
        curr.add(candidates[index]);
        backtrack(curr, index + 1, sum + candidates[index], target, candidates, result);
        curr.remove(curr.size() - 1);
        index++;
        while (index < candidates.length && candidates[index] == candidates[index - 1]) {
            index++;
        }
        backtrack(curr, index, sum, target, candidates, result);
    }
}
