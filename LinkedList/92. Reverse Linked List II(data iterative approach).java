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
    //Data iterative approach
    public int getSizeOfList(ListNode head){
        int size = 0;
        while(head != null){
            ++size;
            head = head.next;
        }
        return size;
    }
    
    //getting node at index 
    //change in head are local changes, so don't affect our original head
    public ListNode getNodeAt(ListNode head, int idx){
        ListNode curr = head;
        for(int i = 0; i < idx; ++i){
            curr = curr.next;
        }
        return curr;
    }
    
    //swapping data of nodes
    public void swapData(ListNode leftNode, ListNode rightNode){
        int tempData = leftNode.val;
        leftNode.val = rightNode.val;
        rightNode.val = tempData;
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int size = getSizeOfList(head);
        while(left <= right){
            //0 indexd list
            ListNode leftNode = getNodeAt(head, left - 1);
            ListNode rightNode = getNodeAt(head, right - 1);
            swapData(leftNode, rightNode);
            ++left;
            --right;
        }
        return head;
    }
}
