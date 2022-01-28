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
    public ListNode getNthNodeFromEnd(ListNode head, int n){
        ListNode fast = head;
        ListNode slow = head;
        //first moving fast by k nodes
        while(fast != null && n > 0){
            fast = fast.next;
            --n;
        }
        
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //0 node or 1 node 
        if(head == null || head.next == null){
            return null;
        }
        
        ListNode nthNode = getNthNodeFromEnd(head, n);
        if(nthNode.next == null){
            ListNode curr = head;
            while(curr.next != nthNode){
                curr = curr.next;
            }
            curr.next = null;
        }else{
            nthNode.val = nthNode.next.val;
            nthNode.next = nthNode.next.next;
        }
        return head;
    }
}
