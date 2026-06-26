class Solution {
    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                myStack.push(c);
            } else if (c == ')') {
                if (myStack.isEmpty() || myStack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (myStack.isEmpty() || myStack.pop() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (myStack.isEmpty() || myStack.pop() != '{') {
                    return false;
                }
            }
        }
        if (!myStack.isEmpty()) {
            return false;
        }
        return true;
    }
}
