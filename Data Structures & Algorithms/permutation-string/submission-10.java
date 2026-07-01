class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> s = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s.put(c, s.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> t = new HashMap<>();
        int left = 0;
        int right = 0;

        while (right < s2.length()) {
            char curr = s2.charAt(right);
            t.put(curr, t.getOrDefault(curr, 0) + 1);
            while (t.get(curr) > s.getOrDefault(curr, 0)) {
                t.put(s2.charAt(left), t.get(s2.charAt(left)) - 1);
                left++;
            }
            if (right - left + 1 == s1.length()) {
                return true;
            }
            right++;
        }
        return false;
    }
}
