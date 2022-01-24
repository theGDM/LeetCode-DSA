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
    //Pointer iterative approach
    public ListNode reverseList(ListNode head) {
        //edge cases
        if(head == null || head.next == null){
            //0 node or 1 node
            return head;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        //now we need to change head pointing to list
        //here i do not to care about tail node.
        head = prev;
        return head;
    }
}
