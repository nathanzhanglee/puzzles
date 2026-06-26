class Solution {
    public boolean isPalindrome(String s) {
        String cleaned = "";
        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned += c; // can you just add char?
            }
        }
        int left = 0;
        int right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
