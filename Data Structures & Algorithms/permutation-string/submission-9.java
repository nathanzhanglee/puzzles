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
            if (s.containsKey(curr)) {
                t.put(curr, t.getOrDefault(curr, 0) + 1);
                if (s.equals(t)) {
                    return true;
                }
                while (s.get(curr) < t.get(curr)) {
                    t.put(s2.charAt(left), t.get(s2.charAt(left)) - 1);
                    left++;
                }
                right++;
            } else {
                right++;
                t.clear();
                left = right;
            }
        }
        return false;
    }
}
