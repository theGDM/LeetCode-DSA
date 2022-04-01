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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){ //base case, val is not found if we reached null
            return null;
        }
        
        if(root.val == val){ //meeting expectation
            return root;
        }
        
        if(root.val > val){
            return searchBST(root.left, val);
        }else{
            return searchBST(root.right, val);
        }
    }
}
