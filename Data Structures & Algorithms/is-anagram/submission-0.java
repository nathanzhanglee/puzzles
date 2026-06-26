class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] seen = new int[26];
        for (char c: s.toCharArray()) {
            seen[c - 'a']++;
        }
        for (char c: t.toCharArray()) {
            seen[c - 'a']--;
            if (seen[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
