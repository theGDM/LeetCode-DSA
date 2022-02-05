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
        ListNode curr = head;
        int size = 0;
        while(curr != null){
            ++size;
            curr = curr.next;
        }
        return size;
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
    
    public void display(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prevHead = new ListNode(-1);
        ListNode prevTail = prevHead;
         while(getSize(head) != 0){
             ListNode currHead = new ListNode(-1);
             ListNode currTail = currHead;
             // System.out.println(getSize(head)); //checkpoint-0
             if(getSize(head) < k){
                 while(head != null){
                    int val = head.val;
                    ListNode temp = new ListNode(val);
                    currTail.next = temp;
                    currTail = temp;
                    head = head.next; 
                 }
                 currTail.next = null;
             }else{
                 for(int i = 0;i < k; ++i){
                    int val = head.val;
                    ListNode temp = new ListNode(val);
                    currTail.next = temp;
                    currTail = temp;
                    head = head.next;
                 }
                 currTail.next = null;
                 currHead.next = reverse(currHead.next);
             }
            //display(currHead.next); //checkpoint-1     
            prevTail.next = currHead.next;
            while(prevTail.next != null){
                prevTail = prevTail.next;
            }
            //System.out.println(prevTail.val); //checkpoint-2
            //System.out.println(prevTail.val); //checkpoin-3
         }
        return prevHead.next;
    }
}
