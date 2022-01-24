/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            //0 node or 1 node without any loop
            return false;
        }
        
        if(head.next == head){
            //self referential Node, 1 node with loop
            return true;
        }
        
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true; //cycle detected
            }
        }      
        return false; //Cycle not detected  
    }
}
