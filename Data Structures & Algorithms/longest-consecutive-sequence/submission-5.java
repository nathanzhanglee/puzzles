class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int result = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int curr = n;
                while (set.contains(curr + 1)) {
                    curr++;
                }
                result = Math.max(result, curr - n + 1);
            }
        }
        return result;
    }
}
