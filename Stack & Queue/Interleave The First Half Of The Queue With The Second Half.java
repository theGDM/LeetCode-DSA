import java.util.* ;
import java.io.*; 
import java.util.Queue;

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
