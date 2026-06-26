class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>(); // set of chars for CURRENT WINDOW, not for entirety of iteration
        int max = 0;
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
