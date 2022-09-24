import java.util.* ;
import java.io.*; 
import java.util.Queue;
//Using queue as extra space
public class Solution {
    public static void interLeaveQueue(Queue<Integer> q) {
        Queue<Integer> temp = new ArrayDeque<>();
        int n = q.size() / 2; //q size is even
        
        while(temp.size() < n){ //first remove the n / 2 elements from q and add to temp
            temp.add(q.remove());
        }
        
        while(temp.size() != 0){
            q.add(temp.remove());
            q.add(q.remove());
        }
    }
}


import java.util.* ;
import java.io.*; 
import java.util.Queue;
//using stack as extra space
//TC : O(n)
//SC : O(n / 2) ~ O(n)
public class Solution {
    public static void interLeaveQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        int n = q.size() / 2; //q size is even
        
        //lets say we have elements q = 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
        //push half the elements in the q
        //q = 16, 17, 18, 19, 20 : s = 15, 14, 13, 12, 11
        while(s.size() < n){
            s.push(q.remove());
        }
        
        //now enqueue the stack elements at the back of q
        //q = 16, 17, 18, 19, 20, 15, 14, 13, 12, 11
        while(s.size() > 0){
            q.add(s.pop());
        }
        
        //dequeue first half elements of q and add at last
        //q = 15, 14, 13, 12, 11, 16, 17, 18, 19, 20
        
        for(int i = 0; i < n; ++i){
            q.add(q.remove());
        }
        
        //now again add first half of q elements into the stack
        //q = 16, 17, 18, 19, 20 : s = 11, 12, 13, 14, 15
        while(s.size() < n){
            s.push(q.remove());
        }
        
        //now add alternatively
        while(s.size() > 0){
            q.add(s.pop());
            q.add(q.remove());
        }
    }
}
