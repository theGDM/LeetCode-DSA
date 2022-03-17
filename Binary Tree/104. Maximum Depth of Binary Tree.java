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
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){ //base case
            return 0;
        }
        
        int lSubDepth = maxDepth(root.left); //faith call -> left subtree maxDepth
        int rSubDepth = maxDepth(root.right); //faith call -> right subtree axDepth
        
        return Math.max(lSubDepth, rSubDepth) + 1;
    }
}
