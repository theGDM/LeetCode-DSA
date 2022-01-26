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
    public int getSize(ListNode head){
        int size = 0;
        while(head != null){
            ++size;
            head = head.next;
        }
        return size;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        int size1 = getSize(headA);
        
        ListNode temp2 = headB;
        int size2 = getSize(headB);
        
        if(size1 > size2){
            int diff1 = size1 - size2;
            for(int i = 0; i < diff1; ++i){
                headA = headA.next;
            }
        }else{
            int diff2 = size2 - size1;
            for(int i = 0; i < diff2; ++i){
                headB = headB.next;
            }
        }
        
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}
