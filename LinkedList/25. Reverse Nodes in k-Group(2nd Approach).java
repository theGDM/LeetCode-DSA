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
    public ListNode reverse(ListNode head){
        ListNode prev = null; 
        ListNode curr = head;
        
        while(curr != null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        
        return prev;
    }
    
    public int size(ListNode head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        
        return size;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prevHead = new ListNode(-1);
        ListNode prevTail = prevHead;
        
        while(head != null){
            ListNode currHead = new ListNode(-1);
            ListNode currTail = currHead;
            
            if(size(head) < k){
                while(head != null){
                    ListNode temp = new ListNode(head.val);
                    prevTail.next = temp;
                    prevTail = prevTail.next;
                    head = head.next;
                }
            }else{
                for(int i = 0; i < k - 1; ++i){
                    ListNode temp = new ListNode(head.val);
                    currTail.next = temp;
                    currTail = currTail.next;
                    head = head.next;
                }
                
                currTail.next = null;
                prevTail.next = reverse(currHead.next);
            }
            
            while(prevTail != null){
                prevTail = prevTail.next;
            }
        }
        
        return prevHead.next;
    }
}
