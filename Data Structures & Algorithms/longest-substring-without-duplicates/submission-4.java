class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            char curr = s.charAt(right);
            while (set.contains(curr)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(curr);
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
