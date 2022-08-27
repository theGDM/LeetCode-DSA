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
    public boolean evaluateTree(TreeNode root) {
        if(root == null) return false;
        return helper(root);
    }
    
    public boolean helper(TreeNode root){
        if(root.left == null && root.right == null){
            if(root.val == 1){
                return true;
            }else{
                return false;
            }
        }
        
        boolean lans = helper(root.left);
        boolean rans = helper(root.right);
        
        if(root.val == 2){ //2 represents OR operation
            return lans || rans;
        }else{ //3 represents AND Operation
            return lans && rans;
        }
    }
}
