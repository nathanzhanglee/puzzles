class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 1;
        Character most = s.charAt(0);
        int result = 0;
        map.put(most, 1);
        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(most) < map.get(c)) {
                most = c;
            }
            if ((right - left + 1) - map.get(most) <= k) {
                result = Math.max(result, right - left + 1);
            } else {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            right++;
        }
        return result;
    }
}
