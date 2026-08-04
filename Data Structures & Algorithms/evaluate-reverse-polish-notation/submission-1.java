class Solution {
    public int evalRPN(String[] tokens) {
        Stack <Integer> s = new Stack<>();
        for (String curr: tokens) {
            char c = curr.charAt(0);
            if (c == '+') {
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
            } else {
                s.push(Integer.parseInt(curr));
            }
        }
        return s.pop();
    }
}
