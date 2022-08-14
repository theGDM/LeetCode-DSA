// Problem Statement
// You’re given a stack consisting of 'N' integers. Your task is to sort this stack in descending order using recursion.
// We can only use the following functions on this stack S.
// is_empty(S) : Tests whether stack is empty or not.
// push(S) : Adds a new element to the stack.
// pop(S) : Removes top element from the stack.
// top(S) : Returns value of the top element. Note that this function does not remove elements from the stack.
// Note :
// 1) Use of any loop constructs like while, for..etc is not allowed. 
// 2) The stack may contain duplicate integers.
// 3) The stack may contain any integer i.e it may either be negative, positive or zero.
// Input Format:
// The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow.

// The first line of each test case contains an integer 'N', the number of elements in the stack.

// The second line of each test contains 'N' space separated integers.
// Output Format:
// The only line of output of each test case should contain 'N' space separated integers denoting the stack in a sorted order.
// Note :
// You do not need to print anything, it has already been taken care of. Just implement the given function. 

import java.util.*;

public class Solution {
    public static void insertAtsortedPos(Stack<Integer> stk, int val){
        if(stk.size() == 0 || val >= stk.peek()){ //base case
            stk.push(val);
            return;
        }
        
        int tempV = stk.pop();//faith call
        insertAtsortedPos(stk, val);
        stk.push(tempV);
    }

	public static void sortStack(Stack<Integer> stack) {
		    if(stack.isEmpty()){
            return;
        }
        
        int val = stack.pop();
        sortStack(stack);
        insertAtsortedPos(stack, val);
	}
}

import java.util.*;
public class Solution {

    public static void sortStack(Stack<Integer> stk) {
	// Write your code here.
        if(stk.isEmpty()) return;
        
        int top = stk.pop();
        sortStack(stk);
        insertAtCorrectPos(stk, top);
    }
    
    public static void insertAtCorrectPos(Stack<Integer> stk, int val){
        if(stk.isEmpty()){
            stk.push(val);
            return;
        }
        
        if(stk.peek() > val){ //if val is greater than the stack peek, remove it
            int top = stk.pop();
            insertAtCorrectPos(stk, val);
            stk.push(top);
        }else{ //if less than equal to the peek, just add at the top
            stk.push(val);
        }
    }
}
