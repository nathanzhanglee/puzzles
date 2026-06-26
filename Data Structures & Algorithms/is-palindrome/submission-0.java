class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder word = new StringBuilder();
        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                word.append(c);
            }
        }
        String w = word.toString();
        int left = 0;
        int right = w.length() - 1;
        while (left < right) {
            if (w.charAt(left) == w.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
