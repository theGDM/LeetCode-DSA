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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //edge case 1
        if(p == null && q == null){
            return true;
        }
        
        //edge case 2
        if(p == null){
            return false;
        }
        
        //edge case 3
        if(q == null){
            return false;
        }
        
        if(p.val != q.val){
            return false;
        }
        
        boolean lans = isSameTree(p.left, q.left);
        if(lans == false){
            return false;
        }
        
        boolean rans = isSameTree(p.right, q.right);
        if(rans == false){
            return false;
        }
        
        return true;
    }
}

