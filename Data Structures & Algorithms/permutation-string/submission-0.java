class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> m = new HashMap<>();
        for (char c : s1.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        while (right < s2.length()) {
            HashMap<Character, Integer> curr = new HashMap<>();
            char c = s2.charAt(right);
            while (m.get(c) != null) {
                curr.put(c, curr.getOrDefault(c, 0) + 1);
                if (curr.equals(m)) {
                    return true;
                }
                if (m.get(c) < curr.get(c)) {
                    while (s2.charAt(left) != c) {
                        curr.put(s2.charAt(left), s2.charAt(left) - 1);
                        if (curr.get(s2.charAt(left)) == 0) {
                            curr.remove(s2.charAt(left));
                        }
                        left++;
                    }
                    left++;
                }
                right++;
                c = s2.charAt(right);
            }
            right++;
            left = right;
        }
        return false;
    }
}
