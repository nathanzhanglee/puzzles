class MinStack {
    int min;
    Stack<Integer> stack;
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (min == Integer.MAX_VALUE) {
            min = val;
        }
        stack.push(min);
        stack.push(val);
        if (min > val) {
            min = val;
        }
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
