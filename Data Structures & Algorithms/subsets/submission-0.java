class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int[] nums, int index, List<Integer> curr, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        backtrack(nums, index + 1, curr, result);
        curr.remove(curr.size() - 1);
        backtrack(nums, index + 1, curr, result);
    }
}
