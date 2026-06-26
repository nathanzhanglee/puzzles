class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] string1 = new int[26];
        for (char c : s1.toCharArray()) {
            string1[c - 'a']++;
        }
        int[] string2 = new int[26];

        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            string2[c - 'a']++;
            while (string2[c - 'a'] > string1[c - 'a']) {
                char leftChar = s2.charAt(left);
                string2[leftChar - 'a']--;
                left++;
            }
            if (Arrays.equals(string1, string2)) {
                return true;
            }
            right++;
        }
        return false;
    }
}
