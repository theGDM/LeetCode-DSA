class MyStack {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;
    public MyStack() {
        mainQ = new ArrayDeque<>();
        helperQ = new ArrayDeque<>();
    }
    
    public void push(int x) {
        mainQ.add(x); 
    }
    
    public int pop() {
        //emptying the main Q till size is > 1
        while(mainQ.size() > 1){
            helperQ.add(mainQ.remove());
        }
        int val = mainQ.remove();
        //refilling the main Q
        while(helperQ.size() > 0){
            mainQ.add(helperQ.remove());
        }
        return val;
    }
    
    public int top() {
        int val = 0;
        //emptying the main Q
        while(mainQ.size() > 0){
            val = mainQ.remove();
            helperQ.add(val);
        }
        //refilling the main Q
        while(helperQ.size() > 0){
            mainQ.add(helperQ.remove());
        }
        return val;
    }
    
    public boolean empty() {
        if(mainQ.size() == 0){
            return true;
        }
        return false;
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
