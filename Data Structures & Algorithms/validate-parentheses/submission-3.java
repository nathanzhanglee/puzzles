class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else {
                return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
