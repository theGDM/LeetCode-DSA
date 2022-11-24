//TC : O(n), SC : O(n)
// when you iterate through the preorder traversal string, for each char:
// case 1: you see a number c, means you begin to expand a new tree rooted with c, you push it to stack

// case 2.1: you see a #, while top of stack is a number, you know this # is a left null child, put it there as a mark for next coming node k to know it is being the right child.
    
// case 2.2: you see a #, while top of stack is #, you know you meet this # as right null child, you now cancel the sub tree (rooted as t, for example) with these two-# children. But wait, after the cancellation, you continue to check top of stack is whether # or a number:

// ---- if a number, say u, you know you just cancelled a node t which is left child of u. You need to leave a # mark to the top of stack. So that the next node know it is a right child.

// ---- if a #, you know you just cancelled a tree whose root, t, is the right child of u. So you continue to cancel sub tree of u, and the process goes on and on.
class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stk = new Stack<>();
        for(String node : preorder.split(",")){
            while(stk.size() > 0 && stk.peek().equals("#")){
                stk.pop();
                if(stk.size() == 0){
                    return false;
                }
                stk.pop();
            }
            stk.push(node);
        }
        
        return stk.size()==1 && stk.peek().equals("#");
    }
}
