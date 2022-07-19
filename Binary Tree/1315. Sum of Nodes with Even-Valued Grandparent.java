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
//DFS : O(n)
class Solution {
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        helper(root, null, null, 1);
        return sum;
    }
    
    public void helper(TreeNode r, TreeNode p, TreeNode gp, int level){
        if(r == null){ //base case
            return;
        }
        
        //grandparent is not there below level < 3
        if(level >= 3 && gp.val % 2 == 0){
            sum += r.val;
        }
        
        //now, current node will become the parent, and parent of current node
        //will become the grandparent of left and right child of current node.
        helper(r.left, r, p, level + 1); 
        helper(r.right, r, p, level + 1); 
    }
}
