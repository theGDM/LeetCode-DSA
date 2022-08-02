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

//The main hint is, inorder traversal gives us the sorted order sequence,
//and the cosecutive elements difference will give us the min diff.
class Solution {
    public Integer res = Integer.MAX_VALUE, pre = null;
    public int minDiffInBST(TreeNode root) {
        return inorder(root);
    }
    
    public int inorder(TreeNode root){
        if(root.left != null) inorder(root.left);
        //inorder wordk
        if(pre != null){
            res = Math.min(res, root.val - pre);
        }
        
        pre = root.val;//update pre with current root value
        
        if(root.right != null) inorder(root.right);
        return res;
    }
}
