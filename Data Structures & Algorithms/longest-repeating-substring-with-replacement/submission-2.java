class Solution {
    public int characterReplacement(String s, int k) {
        int[] seen = new int[26];
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < s.length()) {
            int leftChar = s.charAt(left) - 'A';
            int rightChar = s.charAt(right) - 'A';
            seen[rightChar]++;
            int max = 0;
            int total = 0;
            for (int i = 0; i < 26; i++) {
                max = Math.max(max, seen[i]);
                total += seen[i];
            }
            int diff = total - max;
            if (diff > k) {
                seen[leftChar]--;
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
