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
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTreeHelp(root, null);
    }
    
    public boolean isUnivalTreeHelp(TreeNode curr, TreeNode prev){
        if(curr == null){
            return true;
        }
        
        if(prev != null){
            if(prev.val != curr.val){
                return false;
            }
        }
        
        boolean lans = isUnivalTreeHelp(curr.left, curr);
        if(lans == false){
            return false;
        }
        
        boolean rans = isUnivalTreeHelp(curr.right, curr);
        if(rans == false){
            return false;
        }
        
        return true;
    }
}
