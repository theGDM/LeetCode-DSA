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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return helper(root, low, high);
    }
    
    public TreeNode helper(TreeNode root, int l, int h){
        if(root == null){
            return null;
        }
        
        root.left = helper(root.left, l, h);
        root.right = helper(root.right, l, h);
        
        //postorder work
        //work will be done in postorder
        if(root.val < l || root.val > h){
            //when node to be deleted is the leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            
            //when node to be deleted don't have left node, replace it with right child
            if(root.left == null){
                return root.right;
            }
            
            //when node to be deleted don't have right node, replace with its left child
            if(root.right == null){
                return root.left;
            }
        }
        
        return root;
    }
}
