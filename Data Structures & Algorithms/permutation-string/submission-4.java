class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> m = new HashMap<>();
        for (char c : s1.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> n = new HashMap<>();
        while (right < s2.length()) {
            char c = s2.charAt(right);
            n.put(c, n.getOrDefault(c, 0) + 1);
            while (n.get(c) > m.getOrDefault(c, 0)) {
                char leftChar = s2.charAt(left);
                n.put(leftChar, n.get(leftChar) - 1);
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

