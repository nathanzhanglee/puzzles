class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> one = new HashMap<>();
        for (char c : s1.toCharArray()) {
            one.put(c, one.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> two = new HashMap<>();
        while (right < s2.length()) {
            char curr = s2.charAt(right);
            two.put(curr, two.getOrDefault(curr, 0) + 1);
            while (two.get(curr) > one.getOrDefault(curr, 0)) {
                char leftChar = s2.charAt(left);
                two.put(leftChar, two.get(leftChar) - 1);
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
