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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(-1);
        ListNode oddTail = oddHead;
        ListNode evenHead = new ListNode(-1);
        ListNode evenTail = evenHead;
        while(head != null){
            oddTail.next = head;
            oddTail = head;
            head = head.next;
            if(head != null){
                evenTail.next = head;
                evenTail = head;
                head = head.next;
            }
        }
    
        evenTail.next = null;
        oddTail.next = evenHead.next;
        return oddHead.next;
    }
}
