class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int result = 0;
        int replaced = 0;
        while (right + 1 < s.length()) {
            char start = s.charAt(left);
            while (right < s.length() && (replaced < k || start == s.charAt(right))) {
                if (start != s.charAt(right)) {
                    replaced++;
                }
                right++;
            }
            result = Math.max(result, right - left);
            while (left < right && s.charAt(left) == start) {
                left++;
            }
            replaced = right - left;
            right++;
        }
        return result;
    }
}
