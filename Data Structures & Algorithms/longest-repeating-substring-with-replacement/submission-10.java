class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 1;
        int result = 0;
        char most = s.charAt(0);
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(most, 1);
        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > map.get(most)) {
                most = c;
            }
            if (right - left + 1 - map.get(most) <= k) {
                result = Math.max(right - left + 1, result);
            } else {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            right++;
        }
        return result;
    }
}
