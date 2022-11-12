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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//Recurrence Relation : T(n) = 2T(n / 2) + O(n) <- preorder wordk to find mid = O(nlogn)
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return helper(head, null);
    }
    
    public TreeNode helper(ListNode head, ListNode tail){
        if(head == tail) return null;
        
        ListNode slow = head, fast = head;
        while(fast != tail && fast.next != tail){ //O(N), //finding the mid
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode node = new TreeNode(slow.val);
        TreeNode left = helper(head, slow);
        TreeNode right = helper(slow.next, tail);
        
        node.left = left;
        node.right = right;
        return node;
    }
}
