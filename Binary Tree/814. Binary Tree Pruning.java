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

//TC : O(n)
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return helper(root);
    }
    
    public TreeNode helper(TreeNode root){
        if(root == null){
            return null;
        }
        
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        
        root.left = left;
        root.right = right;
        
        if(left == null && right == null && root.val == 0){ //if left subtree contains only 0's and right subtree contains only 0s and current node value is 0 too
            return null;
        }else{
            return root;
        }
    }
}
