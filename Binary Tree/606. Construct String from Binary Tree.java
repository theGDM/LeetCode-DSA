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
//SC : O(n)
class Solution {
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode root) {
        helper(root, root);
        return sb.toString();
    }
    
    public void helper(TreeNode root, TreeNode node){
        if(node == null){
            return;
        }
        
        if(node != root){ //to avoid the "(1" this thing
            sb.append("(");
            sb.append(node.val);
        }else{
            sb.append(node.val);
        }
        
        if(node.left == null && node.right != null){ //no need for further calling to left child
            sb.append("()");
        }else{
            helper(root, node.left); //otherwise call the left child
        }
        
        helper(root, node.right); //call the right child
        
        if(node != root){
            sb.append(")");
        }
    }
}
