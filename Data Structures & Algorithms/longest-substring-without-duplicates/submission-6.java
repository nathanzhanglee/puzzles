class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == "") {
            return 0;
        }
        int left = 0; 
        int right = 0;
        int res = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (set.contains(c)) {
                while (s.charAt(left) != c) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            set.add(c);
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
