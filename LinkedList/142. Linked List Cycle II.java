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
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            
            //loop detected
            if(slow == fast) break;
        }
        
        //sll
        if(fast == null || fast.next == null){
          return null; //no cycle  
        }
        
        //cycle
        ListNode curr1 = head, curr2 = slow;
        while(curr1 != curr2){
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        return curr1;
    }
}
