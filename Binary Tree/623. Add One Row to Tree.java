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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        //base cases
        if(depth == 1){
            return new TreeNode(val, root, null);
        }
        
        if(depth == 2){
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        }
        
        //faith calls
        if(root.left != null){
            addOneRow(root.left, val, depth - 1);
        }
        
        if(root.right != null){
            addOneRow(root.right, val, depth - 1);
        }
        
        return root;
    }
}
