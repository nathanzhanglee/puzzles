class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int i = 0;
        int result = 0;
        while (i < tokens.length) {
            char c = tokens[i].charAt(0);
            if (c - '0' <= 9 && c - '0' >= 0) {
                s.add(c - '0');
            } else {
                int second = s.pop();
                int first = s.pop();
                if (c == '+') {
                    result = first + second;
                } else if (c == '-') {
                    result = first - second;
                } else if (c == '*') {
                    result = first * second;
                } else {
                    result = first / second;
                }
                s.push(result);
            }
            i++;
        }
        return s.pop();
    }
}
