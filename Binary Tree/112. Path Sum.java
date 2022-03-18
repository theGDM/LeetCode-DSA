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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, 0, targetSum);
    }
    
    public boolean helper(TreeNode node, int currSum, int targetSum){
        if(node == null){
            return false;
        }
        
        if(node.left == null && node.right == null){ //at leaf node
            currSum += node.val;
            if(currSum == targetSum){
                return true;
            }
            return false;
        }
        
        boolean lRes = helper(node.left, currSum + node.val, targetSum);
        if(lRes){ //if lRes true that means we found that path, so terminate the dfs
            return lRes;
        }
        
        boolean rRes = helper(node.right, currSum + node.val, targetSum);
        if(rRes){ //if rRes true that means we found that path, so terminate the dfs
            return rRes;
        }
        
        return false;
    }
}
