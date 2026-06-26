class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> m = new HashMap<>();
        int left = 0;
        int right = 1;
        char most = s.charAt(0);
        int res = Integer.MIN_VALUE;
        m.put(most, 1);
        while (right < s.length()) {
            char c = s.charAt(right);
            m.put(c, m.getOrDefault(c, 0) + 1);
            if (m.get(c) > m.get(most)) {
                most = c;
            }
            if (right - left + 1 - m.get(most) <= k) {
                res = Math.max(res, right - left + 1);
            } else {
                m.put(s.charAt(left), m.get(s.charAt(left)) - 1);
                left++;
            }
            right++;
        }
        return res;
    }
}
