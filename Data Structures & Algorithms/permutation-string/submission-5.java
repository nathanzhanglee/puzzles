class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> m = new HashMap<>();
        for (char c : s1.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> string2 = new HashMap<>();
        while (right < s2.length()) {
            char curr = s2.charAt(right);
            string2.put(curr, string2.getOrDefault(curr, 0) + 1);
            while (string2.get(curr) > m.getOrDefault(curr, 0)) { // minimizes window until earliest instance of curr, 
            // whether it's right now (AKA curr is not in string) or previous (curr has one of more occurancs)
                char leftChar = s2.charAt(left);
                string2.put(leftChar, string2.getOrDefault(leftChar, 0) - 1);
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

