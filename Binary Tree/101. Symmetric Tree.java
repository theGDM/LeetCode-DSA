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
    public boolean isMirror(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        
        if(p == null){
            return false;
        }
        
        if(q == null){
            return false;
        }
        
        if(p.val != q.val){
            return false;
        }
        
        boolean tempAns1 = isMirror(p.left, q.right);
        if(tempAns1 == false){
            return false;
        }
        
        boolean tempAns2 = isMirror(p.right, q.left);
        if(tempAns2 == false){
            return false;
        }
        
        return true;    
    }
    
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
          return true;
        }
        
        return isMirror(root, root);
    }
}
