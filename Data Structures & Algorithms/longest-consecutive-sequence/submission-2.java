class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int n : nums) {
            int length = 1;
            int curr = n;
            if (!map.containsKey(curr)) {
                length += map.getOrDefault(curr + 1, 0);
                length += map.getOrDefault(curr - 1, 0);
                map.put(curr, length);
                result = Math.max(result, length);
                while (map.containsKey(curr - 1)) {
                    curr--;
                    map.put(curr, length);
                }
                curr = n;
                while (map.containsKey(curr + 1)) {
                    curr++;
                    map.put(curr, length);
                }
            }
        }
        return result;
    }
}
