class Solution {
    public int evalRPN(String[] tokens) {
        Stack <Integer> s = new Stack<>();
        for (String curr: tokens) {
            char c = curr.charAt(0);
            if (Character.isDigit(c)) {
                s.push(c - '0');
            } else if (c == '+') {
                int right = s.pop();
                int left = s.pop();
                s.push(left + right);
            } else if (c == '-') {
                int right = s.pop();
                int left = s.pop();
                s.push(left - right);
            } else if (c == '*') {
                int right = s.pop();
                int left = s.pop();
                s.push(left * right);
            } else if (c == '/') {
                int right = s.pop();
                int left = s.pop();
                s.push(left / right);
            }
        }
        return s.pop();
    }
}
