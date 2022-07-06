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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        ListNode dummyTail = dummy;
        
        head = head.next;
        while(head != null){
            int sum = 0;
            
            while(head.val != 0){
                sum += head.val;
                head = head.next;
            }
            
            ListNode temp = new ListNode(sum); //make new node
            dummyTail.next = temp;
            dummyTail = dummyTail.next;
            head = head.next; //next iteration
        }
        
        return dummyHead.next;
    }
}
