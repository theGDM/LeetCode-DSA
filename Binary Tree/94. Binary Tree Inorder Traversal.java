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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }
    
    public void inorder(TreeNode node, List<Integer> ans){
        if(node == null){ //no tree
            return;
        }
        
        //pre
        inorder(node.left, ans);
        //in
        ans.add(node.val);
        //post
        inorder(node.right, ans);
    }
}
