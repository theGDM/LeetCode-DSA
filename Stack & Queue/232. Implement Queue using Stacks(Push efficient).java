class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        while(s1.size() > 0){
            s2.push(s1.pop());
        }
        int val = s2.pop();
        while(s2.size() > 0){
            s1.push(s2.pop());
        }
        return val;
    }
    
    public int peek() {
        while(s1.size() > 0){
            s2.push(s1.pop());
        }
        int val = s2.peek();
        while(s2.size() > 0){
            s1.push(s2.pop());
        }
        return val;
    }
    
    public boolean empty() {
        if(s1.size() == 0){
            return true;
        }
        return false;
    }
}
