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
//TC : O(n), as we are visiting each and every node
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return helper(root, low, high);
    }
    
    public int helper(TreeNode root, int low, int high){
        if(root == null) return 0;
        int ans = 0;
        
        int left = helper(root.left, low, high);
        if(root.val >= low && root.val <= high){
            ans += root.val;
        }
        int right = helper(root.right, low, high);
        return left + right + ans;
    }
}

