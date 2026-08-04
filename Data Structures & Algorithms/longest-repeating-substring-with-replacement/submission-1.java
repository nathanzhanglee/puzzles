class Solution {
    public int characterReplacement(String s, int k) {
        int[] seen = new int[26];
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            int leftChar = s.charAt(left) - 'A';
            int rightChar = s.charAt(right) - 'A';
            seen[rightChar]++;
            int diff = 0;
            for (int i = 0; i < 26; i++) {
                if (i == leftChar) {
                    continue;
                }
                diff += seen[i];
            }
            if (diff > k) {
                seen[leftChar]--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        right = s.length() - 1;
        left = s.length() - 1;
        while (left >= 0) {
            int leftChar = s.charAt(left) - 'A';
            int rightChar = s.charAt(right) - 'A';
            seen[leftChar]++;
            int diff = 0;
            for (int i = 0; i < 26; i++) {
                if (i == rightChar) {
                    continue;
                }
                diff += seen[i];
            }
            if (diff > k) {
                seen[rightChar]--;
                right--;
            }
            max = Math.max(max, right - left + 1);
            left--;
        }
        return max;
    }
}
