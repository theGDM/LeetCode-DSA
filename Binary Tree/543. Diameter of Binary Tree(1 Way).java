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
    public int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return dia;
    }
    
    public int helper(TreeNode node){
        if(node == null){
            return -1;
        }
        
        int ld = helper(node.left);
        int rd = helper(node.right);
        
        if(ld + rd + 2 > dia){
            dia = ld + rd + 2;
        }
        
        if(ld > rd){
            return ld + 1;
        }else{
            return rd + 1;
        }
    }
}
