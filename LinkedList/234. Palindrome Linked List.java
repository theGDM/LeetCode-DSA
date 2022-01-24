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
    //function to fine middle node
    public ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast == null){ //No. of nodes are even
            return prev;
        }else{
            return slow;
        }
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        
        return prev;
    }
    
    public void displayList(ListNode head){
        while(head != null){
            System.out.print(head.val + " "); 
            head = head.next;
        }
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){ //0 or 1 node
            return true;
        }
        
        ListNode mid = middle(head);
        ListNode midNext = reverse(mid.next); //LinkedList II from mid + 1 node to tail
        mid.next = null; //terminating LinkedList I from head to mid node
        
        // displayList(head);
        // displayList(midNext);
        
        while(head != null && midNext != null){
            if(head.val != midNext.val) return false;
            head = head.next;
            midNext = midNext.next;
        }
        
        return true;
    }
}
