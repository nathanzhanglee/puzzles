class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 1;
        char most = s.charAt(0);
        map.put(most, 1);
        int result = 0;
        while (right < s.length()) {
            char curr = s.charAt(right);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            if (map.get(curr) > map.get(most)) {
                most = curr;
            }
            if (right - left + 1 - map.get(most) <= k) {
                result = Math.max(right - left + 1, result);
            } else {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            right++;
        }
        return result;
    }
}
