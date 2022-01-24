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
    
    public ListNode reverseList(ListNode head) {
        int size = getSizeOfList(head);
        int left = 0, right = size - 1;
        while(left < right){
            ListNode leftNode = getNodeAt(head, left);
            ListNode rightNode = getNodeAt(head, right);
            swapData(leftNode, rightNode);
            ++left;
            --right;
        }
        return head;
    }
}
