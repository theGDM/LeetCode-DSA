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
//Brute Force
//TC : O(n2)
class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return count;
    }
    
    public void dfs(TreeNode root, int ts){ //O(n)
        if(root == null) return;
        
        helper(root, 0, ts); //O(n) work, treating every node as root, and running helper function
        //calls
        dfs(root.left, ts);
        dfs(root.right, ts);
    }
    
    public void helper(TreeNode root, long cs, int ts){ //O(n)
        if(root == null) return;
        
        if((long)root.val + cs == ts){ //important
            count++;
        }
        
        helper(root.left, cs + root.val, ts);
        helper(root.right, cs + root.val, ts);
    }
}
