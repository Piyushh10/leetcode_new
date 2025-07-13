class MyStack {
    Queue<Integer> stack;
    public MyStack() {
        stack =new LinkedList<>();
    }
    
    public void push(int x) {
        stack.add(x);
        for(int i = 0; i<stack.size()-1; i++){
            int val = stack.remove();
            stack.add(val);
        }
    }
    
    public int pop() {
        if(stack.size() == 0){
            return -1;
        }
        return stack.remove();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */