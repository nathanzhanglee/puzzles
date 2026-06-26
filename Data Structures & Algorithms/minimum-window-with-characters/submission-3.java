class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        HashMap<Character, Integer> m = new HashMap<>();
        for (char c : t.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int finalLeft = 0;
        int finalRight = 0;
        int have = 0;
        int need = m.keySet().size();
        HashMap<Character, Integer> n = new HashMap<>();
        while (right < s.length()) {
            char curr = s.charAt(right);
            n.put(curr, n.getOrDefault(curr, 0) + 1);
            if (n.get(curr) == m.getOrDefault(curr, 0)) {
                have++;
            }
            while (have == need) {
                if (min > right - left + 1) {
                    min = right - left + 1;
                    finalLeft = left;
                    finalRight = right + 1;
                }
                char leftChar = s.charAt(left);
                n.put(leftChar, n.get(leftChar) - 1);
                if (n.get(leftChar) < m.getOrDefault((leftChar), 0)) {
                    have--;
                }
                left++;
            }
            right++;
        }
        return s.substring(finalLeft, finalRight);
    }
}
