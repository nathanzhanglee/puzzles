class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int result = 0;
        int replaced = 0;
        while (right < s.length()) {
            char start = s.charAt(left);
            while (right + 1 < s.length() && (replaced < k || start == s.charAt(right + 1))) {
                if (start != s.charAt(right)) {
                    replaced++;
                }
                right++;
            }
            result = Math.max(result, right - left + 1);
            while (left < right && s.charAt(left) == start) {
                left++;
            }
            replaced = right - left;
            right++;
        }
        return result;
    }
}
