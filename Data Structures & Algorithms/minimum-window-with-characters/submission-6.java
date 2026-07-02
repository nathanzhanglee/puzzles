class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> string1 = new HashMap<>();
        for (char c : t.toCharArray()) {
            string1.put(c, string1.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> string2 = new HashMap<>();
        int need = string1.keySet().size();
        int have = 0;
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int fLeft = 0;
        int fRight = 0;
        while (right < s.length()) {
            char curr = s.charAt(right);
            string2.put(curr, string2.getOrDefault(curr, 0) + 1);
            if (string2.get(curr) == string1.getOrDefault(curr, 0)) {
                have++;
                while (have == need) {
                    if (minLength > right - left + 1) {
                        minLength = right - left + 1;
                        fLeft = left;
                        fRight = right;
                    }
                    char leftChar = s.charAt(left);
                    string2.put(leftChar, string2.get(leftChar) - 1);
                    if (string2.get(leftChar) < string1.getOrDefault(leftChar, 0)) {
                        have--;
                    }
                    left++;
                }
            }
            right++;
        }
        return (minLength == Integer.MAX_VALUE ? "" : s.substring(fLeft, fRight + 1));
    }
}
