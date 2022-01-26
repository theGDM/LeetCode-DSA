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
    public ListNode getMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null){ //only one node is there
            return null;
        }
        
        ListNode mid = getMiddleNode(head);
        if(mid.next != null){
            mid.val = mid.next.val;
            if(mid.next.next != null){ //mid node is the second last node
                mid.next = mid.next.next;
            }else{
                mid.next = null;
            }
        }else{ //mid node is the last node itself
            mid.val = head.val;
            head = mid;
        }
        return head;
    }  
}
