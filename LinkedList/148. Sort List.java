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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){ //if both lists are empty
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy, dummyTail = dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                dummyTail.next = list1;
                list1 = list1.next;
            }else{
                dummyTail.next = list2;
                list2 = list2.next;
            }
            dummyTail = dummyTail.next;
        }
        if(list1 != null) dummyTail.next = list1;
        else dummyTail.next = list2;
        return dummyHead.next;
    }
    
    public ListNode getMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast == null){
            return prev;
        }else{
            return slow;
        }
    }
    
    public ListNode sortList(ListNode head) {
        //base case
        if(head == null || head.next == null){
            return head;
        }
        //splitting the lists in two parts
        ListNode mid = getMiddle(head);
        ListNode midNext = mid.next;
        mid.next = null;
        //faith calls
        ListNode left = sortList(head);
        ListNode right = sortList(midNext);
        //meeting expectation with faith
        return mergeTwoLists(left, right);
    }
}
