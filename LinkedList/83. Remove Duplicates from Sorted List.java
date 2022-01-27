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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode dummyTail = dummyHead;
        while(head != null){
            if(dummyHead == dummyTail || head.val != dummyTail.val){
                dummyTail.next = head;
                dummyTail = head;
            }
            head = head.next;
        }
        dummyTail.next = null;
        return dummyHead.next;
    }
}
