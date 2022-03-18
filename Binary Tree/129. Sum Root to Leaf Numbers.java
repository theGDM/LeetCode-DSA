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
    public int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, "");
        return sum;
    }
    
    public void helper(TreeNode node, String currSum){
        if(node == null){ //base case
            return;
        }
        
        if(node.left == null && node.right == null){
            currSum += node.val;//adding current node value
            sum += Integer.parseInt(currSum);
            return;
        }
        
        helper(node.left, currSum + node.val);//faith call
        helper(node.right, currSum + node.val);//faith call
    }
}
