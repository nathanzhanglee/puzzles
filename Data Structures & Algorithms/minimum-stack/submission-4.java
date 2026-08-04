class MinStack {
    int min;
    Stack<Integer> stack;
    boolean first;
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
        first = true;
    }
    
    public void push(int val) {
        if (first) {
            min = val;
            first = false;
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
