class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int result = 0;
        for (int n : nums) {
            int curr = n;
            int length = 1;
            if (!set.contains(curr - 1)) {
                while (set.contains(curr + 1)) {
                    curr++;
                    length++;
                }
            }
            result = Math.max(result, length);
        }
        return result;
    }
}
