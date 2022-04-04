// You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. 
// That is, all the 1's will appear to the left of all the 0's in each row.

// A row i is weaker than a row j if one of the following is true:

// The number of soldiers in row i is less than the number of soldiers in row j.
// Both rows have the same number of soldiers and i < j.
// Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.

// Example 1:

// Input: mat = 
// [[1,1,0,0,0],
//  [1,1,1,1,0],
//  [1,0,0,0,0],
//  [1,1,0,0,0],
//  [1,1,1,1,1]], 
// k = 3
// Output: [2,0,3]
// Explanation: 
// The number of soldiers in each row is: 
// - Row 0: 2 
// - Row 1: 4 
// - Row 2: 1 
// - Row 3: 2 
// - Row 4: 5 
// The rows ordered from weakest to strongest are [2,0,3,1,4].
// Example 2:

// Input: mat = 
// [[1,0,0,0],
//  [1,1,1,1],
//  [1,0,0,0],
//  [1,0,0,0]], 
// k = 2
// Output: [0,2]
// Explanation: 
// The number of soldiers in each row is: 
// - Row 0: 1 
// - Row 1: 4 
// - Row 2: 1 
// - Row 3: 1 
// The rows ordered from weakest to strongest are [0,2,3,1].

class Solution {
    //pair class
    public class Pair{
        int i;
        int sNo;
        
        Pair(){}; //explicit default constructor
        
        Pair(int i, int sNo){ //parametrized constructor
            this.i = i;
            this.sNo = sNo;
        }
    }
    
    //sorting the array of pair on the basis of soldier number using bubble sort algorithm
    public void sortPair(Pair[] p){
        for(int i = 1;i < p.length; ++i){
            for(int j = 0;j < p.length - i; ++j){
                if(p[j + 1].sNo < p[j].sNo){
                    Pair temp = p[j + 1];
                    p[j + 1] = p[j];
                    p[j] = temp;
                }
            }
        }
    } 
    
    public int[] kWeakestRows(int[][] mat, int k) {
        Pair[] weakestRow = new Pair[mat.length];
        int[] res = new int[k];
        for(int i = 0; i < mat.length; ++i){
            int soldier = 0;
            for(int j = 0; j < mat[0].length; ++j){
                if(mat[i][j] == 1){
                    ++soldier;
                }
            }
            Pair p = new Pair(i, soldier);
            weakestRow[i] = p;
        }
        
        sortPair(weakestRow); //sorting the array of pair on the basis of soldir no
        
        for(int i = 0;i < k; ++i){
            res[i] = weakestRow[i].i;
        }
        
        return res;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        
        for(int i = 0;i < k - 1; ++i){
            fast = fast.next;
        }
        
        ListNode first = fast;
        
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        ListNode last = slow;
        
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
            
        return head;
    }
}
