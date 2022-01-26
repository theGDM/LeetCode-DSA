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
    public int minimum(ListNode[] lists){
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for(int i = 0 ;i < lists.length; ++i){
            //if head of any list is null it means that list is out of race.
            if(lists[i] != null && lists[i].val < min){
                min = lists[i].val;
                idx = i;
            }
        }
        return idx;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy, dummyTail = dummy;
        while(true){
            int minIdx = minimum(lists);
            if(minIdx == -1) break;
            dummyTail.next = lists[minIdx];
            dummyTail = lists[minIdx];
            lists[minIdx] = lists[minIdx].next;
        }
        dummyTail.next = null;
        return dummyHead.next;
    }
}
