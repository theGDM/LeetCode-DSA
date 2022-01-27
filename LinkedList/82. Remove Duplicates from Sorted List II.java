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
            //head.next == null for last node which is not duplicate
            if(head.next == null || head.next.val != head.val){
                dummyTail.next = head;
                dummyTail = head;
                head = head.next;
            }else{
                ListNode curr = head;
                while(curr != null && curr.val == head.val){
                    curr = curr.next;
                }
                head = curr;
            }
        }
        dummyTail.next = null;
        return dummyHead.next;
    }
} 
