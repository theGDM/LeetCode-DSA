/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //using floyd cycle
    public ListNode detectCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){ //loop detected
                break;
            }
        }
        
        //no loop detected(SLL)
        if(fast == null || fast.next == null) return null;
        
        ListNode curr1 = slow, curr2 = head;
        while(curr1 != curr2){
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return curr1;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tailA = headA;
        while(tailA.next != null){
            tailA = tailA.next;
        }
        //making loop
        tailA.next = headA;
        ListNode intersectionNode = detectCycle(headB);
        tailA.next = null;
        return intersectionNode;
    }
}
