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

//first find the heigth of the tree
//then the leaf node, present at that height, will be added in the result
class Solution {
    int res;
    public int deepestLeavesSum(TreeNode root) {
        res = 0;
        int height = getHeight(root);
        helper(root, 1, height);
        return res;
    }
    
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        
        return Math.max(lh, rh) + 1;
    }
    
    public void helper(TreeNode root, int ch, int mh){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.left == null && ch == mh){
            res += root.val;
            return;
        }
        
        helper(root.left, ch + 1, mh);
        helper(root.right, ch + 1, mh);
    }
}
