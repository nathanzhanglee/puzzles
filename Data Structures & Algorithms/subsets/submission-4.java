class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, nums, result);
        return result;
    }

    public void backtrack(List<Integer> curr, int index, int[] nums, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        backtrack(curr, index + 1, nums, result);
        curr.remove(curr.size() - 1);
        backtrack(curr, index + 1, nums, result);
    }

}
