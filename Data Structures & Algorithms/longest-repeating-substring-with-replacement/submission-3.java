class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> m = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        char maxChar = s.charAt(0);
        while (right < s.length()) {
            char curr = s.charAt(right);
            m.put(curr, m.getOrDefault(curr, 0) + 1);
            if (m.get(maxChar) < m.get(curr)) {
                maxChar = curr;
            }
            if (right - left + 1 - m.get(maxChar) <= k) {
                res = Math.max(right - left + 1, res);
            } else {
                m.put(s.charAt(left), m.get(s.charAt(left)) - 1);
                left++;
            }
            right++;
        }
        return res;
    }
}
