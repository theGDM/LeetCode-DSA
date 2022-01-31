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
    public int getSize(ListNode head){
       int size = 0;
        while(head != null){
            ++size;
            head = head.next;
        }
        return size;
    }
    
    public ListNode getTail(ListNode head){
        ListNode curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        return curr;
    }
    
    public ListNode getNthNode(ListNode head, int k){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && k != 0){
            fast = fast.next;
            --k;
        }
        
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        int size = getSize(head);
        
        if(size == 0){
            return null;
        }
        
        //handling larger values of k
        k = k % size;
        
        //handling -ve values of k
        if(k < 0){
            k = k + size;
        }
        
        //edge case
        if(k == 0) return head;
        
        ListNode nthNode = getNthNode(head, k);
        ListNode tail = getTail(head);
        tail.next = head;
        while(head.next != nthNode){
            head = head.next;
        }
        head.next = null;
        return nthNode;    
    }
}
