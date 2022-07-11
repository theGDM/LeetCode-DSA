class MinStack {
    Stack<Integer> dataStk;
    Stack<Integer> minStk;
   
    public MinStack() {
        dataStk = new Stack<>();
        minStk = new Stack<>();
        minStk.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        dataStk.push(val);
        if(val < minStk.peek()){
            minStk.push(val);
        }else{
            minStk.push(minStk.peek());
        }

    }
    
    public void pop() {
        if(dataStk.size() == 0){
            return;
        }
        //pop from both stack
        dataStk.pop();
        minStk.pop();
    }
    
    public int top() {
        if(dataStk.size() == 0){
            return -1;
        }
        return dataStk.peek();
    }
    
    public int getMin() {
        if(minStk.size() == 0) return -1;
        return minStk.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
