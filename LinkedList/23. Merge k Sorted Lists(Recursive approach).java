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
    
    public ListNode helper(ListNode[] lists, int left, int right){
        if(left == right){
            return lists[left];
        }
        
        int mid = (left + right) / 2;
        ListNode l1 = helper(lists, left, mid);
        ListNode l2 = helper(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        
        return helper(lists, 0, lists.length - 1);
    }
}
