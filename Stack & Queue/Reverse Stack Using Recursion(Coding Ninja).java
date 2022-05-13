// Reverse a given stack of integers using recursion.
// Note:
// You are not allowed to use any extra space other than the internal stack space used due to recursion.
// You are not allowed to use the loop constructs of any sort available as handy. For example: for, for-each, while, etc. 
// The only inbuilt stack methods allowed are:
// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// Input Format :
// The first line of input contains an integer value N, denoting the size of the input Stack.

// The second line contains N single space-separated integers, denoting the stack elements, where the last (Nth) element is the 
// TOP most element of Stack. 

import java.util.Stack;

public class Solution {
    	public static void reverseStack(Stack<Integer> stack) {
		    // write your code here
        if(stack.size() == 0){
            return;
        }
		    int val = stack.pop(); //preorder work
        reverseStack(stack); //faith call
        insertAtBottom(stack, val); //post order work(meeting expectation)
	}
    
    public static void insertAtBottom(Stack<Integer> stack, int bottom){
        if(stack.size() == 0){ //base case me push kardo val ko
            stack.push(bottom);
            return;
        }
        
        int val = stack.pop();
        insertAtBottom(stack, bottom);
        stack.push(val);//post order me jo pop kiya use push karte jao
    }
}

