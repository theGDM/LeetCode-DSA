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
//tail(exclusive)
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


//Recurrence Relation : T(n) = 2T(n / 2) + O(n) <- preorder wordk to find mid = O(nlogn)
//Personally if you think that using a head and a tail(exclusive) is not that easy to memorize.
//I found that we can simply cut the left sub list and then recur, so that the recursion stops itself.

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head);
    }
    
    public TreeNode helper(ListNode head){
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){ //O(n), //finding the mid
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null; //break the left sub linked list
        TreeNode node = new TreeNode(slow.val);
        node.left = helper(head);
        node.right = helper(slow.next);
        return node;
    }
}


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
//TC : O(nlog)
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        
        if(head.next == null){
            return new TreeNode(head.val);
        }
        
        ListNode mid = getMid(head);
        ListNode second = mid.next;
        mid.next = null;
        
        //Now getting the list excluding the mid node
        ListNode curr = head;
        while(curr.next != mid){
            curr = curr.next;
        }
        
        curr.next = null;
        TreeNode root = new TreeNode(mid.val);
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(second);
        
        root.left = left;
        root.right = right;
        return root;
        
    }
    
    public ListNode getMid(ListNode head){
        ListNode fast = head, slow = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}
