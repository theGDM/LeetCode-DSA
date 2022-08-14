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
    public ListNode partition(ListNode head, int x){
        ListNode leftHead = new ListNode(-1);
        ListNode rightHead = new ListNode(-1);
        ListNode leftTail = leftHead, rightTail = rightHead;
        while(head != null){
            if(head.val < x){
                leftTail.next = head;
                leftTail = head;
            }else{
                rightTail.next = head;
                rightTail = head;
            }
            head = head.next;
        }
        
        leftTail.next = null;
        rightTail.next = null;
        
        return leftHead.next;
    }
    
    public ListNode getTail(ListNode head){
        if(head == null) return null;
        while(head.next != null){
            head = head.next;
        }
        
        return head;
    }
    
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        //getting lefthead of left partitioned list and righthead by head.next
        ListNode leftHead = partition(head, head.val);
        ListNode rightHead = head.next;
        
        ListNode left = sortList(leftHead);
        ListNode right = sortList(rightHead);
        
        //postorder work
        head.next = right; //connecting head node which is already in sorted position to sorted right list
        if(left == null) return head;
        ListNode leftTail = getTail(left);
        leftTail.next = head;
        return left;
    }
}
