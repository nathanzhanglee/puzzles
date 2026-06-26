class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int result = 0;
        for (int n : nums) {
            int currLength = 1;
            if (!set.contains(n - 1)) {
                while (set.contains(n + currLength)) {
                    currLength++;
                }
            }
            result = Math.max(result, currLength);
        }
        return result;
    }
}
