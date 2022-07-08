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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        int frow = 0, lrow = m - 1, fcol = 0, lcol = n - 1;
     
        int count = 0;    
        while(true){
            for(int i = fcol; i <= lcol; ++i){
                if(head != null){
                    res[frow][i] = head.val;
                    head = head.next;
                }else{
                    res[frow][i] = -1;
                }
                
                ++count;
            }
            if(count == m * n){
                return res;
            }
            ++frow;
            
            for(int j = frow; j <= lrow; ++j){
                if(head != null){
                    res[j][lcol] = head.val;
                    head = head.next;
                }else{
                    res[j][lcol] = -1;
                }
                
                ++count;
            }
            if(count == m * n){
                return res;
            }
            --lcol;
            
            for(int k = lcol; k >= fcol; --k){
                if(head != null){
                    res[lrow][k] = head.val;
                    head = head.next;
                }else{
                    res[lrow][k] = -1;
                }
                
                ++count;
            }
            if(count == m * n){
                return res;
            }
            --lrow;
            
            for(int l = lrow; l >= frow; --l){
                if(head != null){
                    res[l][fcol] = head.val;
                    head = head.next;
                }else{
                    res[l][fcol] = -1;
                }
                
                ++count;
            }
            if(count == m * n){
                return res;
            }
            ++fcol;
        }
 
    }
}
