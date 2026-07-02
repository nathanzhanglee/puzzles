class MinStack {
    int min;
    Stack<Integer> stack;
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
        }
        stack.push(min);
        stack.push(val);
        min = Math.min(min, val);
    }
    
    public void pop() {
        stack.pop();
        min = stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
