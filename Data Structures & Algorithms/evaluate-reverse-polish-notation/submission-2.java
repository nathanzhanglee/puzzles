class Solution {
    public int evalRPN(String[] tokens) {
        Stack <Integer> s = new Stack<>();
        for (String c: tokens) {
            if (c.equals("+")){
                int right = s.pop();
                int left = s.pop();
                s.push(left + right);
            } else if (c.equals("-")) {
                int right = s.pop();
                int left = s.pop();
                s.push(left - right);
            } else if (c.equals("*")) {
                int right = s.pop();
                int left = s.pop();
                s.push(left * right);
            } else if (c.equals("/")) {
                int right = s.pop();
                int left = s.pop();
                s.push(left / right);
            } else {
                s.push(Integer.parseInt(c));
            }
        }
        return s.pop();
    }
}
