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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root, "", ans);
        return ans;
    }
    
    public void helper(TreeNode node, String currPath, List<String> ans){
        if(node == null){
            return;
        }
        
        if(node.left == null && node.right == null){
            currPath += node.val;
            ans.add(currPath);
            return;
        }
        
        helper(node.left, currPath + node.val + "->", ans);
        helper(node.right, currPath + node.val + "->", ans);
    }
}
