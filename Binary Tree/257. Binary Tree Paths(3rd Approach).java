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
        List<String> res = new ArrayList<>();
        helper(root, new ArrayList<>(), res);
        return res;
    }
    
    public void helper(TreeNode node, List<String> path, List<String> res){
        if(node == null){ //no tree
            return;
        }
        
        if(node.left == null && node.right == null){ //at leaf node
            path.add(Integer.toString(node.val));
            res.add(String.join("->", path));
            path.remove(path.size() - 1);//backtrack
            return;
        }
        
        path.add(Integer.toString(node.val));
        helper(node.left, path, res);
        helper(node.right, path, res);
        path.remove(path.size() - 1);//backtrack
    }
}
