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
    public int total = 0;
    public int sumRootToLeaf(TreeNode root) {
        helper(root, 0);
        return total;
    }
    
    public void helper(TreeNode node, int currSum){
        if(node == null){//if no tree present
            return;
        }
        
        if(node.left == null && node.right == null){//base case
            currSum = currSum * 2 + node.val;
            total += currSum;
            return;   
        }
        
        currSum = currSum * 2 + node.val;
        //faith calls
        helper(node.left, currSum);
        helper(node.right, currSum);
    }
}
