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
    public ListNode getKthNodeFromLast(ListNode head, int k){
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && k > 0){
            fast = fast.next;
            --k;
        }
        
        if(k > 0) return null;
        
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    public ListNode getKthNodeFromFirst(ListNode head, int k){
        while(head != null && k - 1 > 0){
            head = head.next;
            --k;
        }
        
        return head;
    }
    
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = getKthNodeFromFirst(head, k);
        ListNode last = getKthNodeFromLast(head, k);
        
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
            
        return head;
    }
}
