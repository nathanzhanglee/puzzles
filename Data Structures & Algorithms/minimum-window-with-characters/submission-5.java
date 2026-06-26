class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int need = freq.keySet().size();
        int have = 0;
        int left = 0;
        int right = 0;
        int leftMin = 0;
        int rightMin = 0;
        int min = Integer.MAX_VALUE;
        HashMap<Character, Integer> m = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            m.put(c, m.getOrDefault(c, 0) + 1);
            if (m.get(c) == freq.getOrDefault(c, 0)) {
                have++;
            }
            while (have == need) {
                if (right - left + 1 < min) {
                    leftMin = left;
                    rightMin = right + 1;
                    min = right - left + 1;
                } 
                char leftChar = s.charAt(left);
                m.put(leftChar, m.get(leftChar) - 1);
                if (freq.getOrDefault(leftChar, 0) > m.get(leftChar)) {
                    have--;
                } 
                left++;
            }
            right++;
        }
        return s.substring(leftMin, rightMin);
    }
}