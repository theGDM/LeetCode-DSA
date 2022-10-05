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
//SC : O(n), recursion call stack ka space
class Solution {
    public int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathSum_NTN(root);
        return max;
    }
    
    //it return maximum root to node,but also calculates maximum node to node
    public int maxPathSum_NTN(TreeNode root){
        if(root == null) return 0;
        
        int lans = maxPathSum_NTN(root.left);
        int rans = maxPathSum_NTN(root.right);
        
        int lans_dash = Math.max(0, lans);
        int rans_dash = Math.max(0, rans);
        
        int sumFromLeftToRight = lans_dash + root.val + rans_dash;
        if(sumFromLeftToRight > max){
            max = sumFromLeftToRight;
        }
        
        return Math.max(lans_dash, rans_dash) + root.val;
    }
}
