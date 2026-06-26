class MinStack {
    Stack<Integer> s;
    Stack<Integer> mins;
    public MinStack() {
        s = new Stack<>();
        mins = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if (mins.isEmpty() || mins.peek() >= val) {
            mins.push(val);
        }
    }
    
    public void pop() {
        int val = s.pop();
        if (val == mins.peek()) {
            mins.pop();
        }
    }
    
    public int top() {
        return s.peek();   
    }
    
    public int getMin() {
        return mins.peek();
    }
}
