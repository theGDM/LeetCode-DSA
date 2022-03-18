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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, new ArrayList<>(), 0, targetSum, res);
        return res;
    }
    
    public void helper(TreeNode node, List<Integer> path, int cs, int ts, List<List<Integer>> res){
        if(node == null){
            return;
        }
        
        if(node.left == null && node.right == null){
            path.add(node.val);
            cs += node.val;
            // System.out.print(cs + " " + ts);
            // System.out.println(path);
            if(cs == ts){
                res.add(new ArrayList<>(path));//imporatant concept //make new arraylist with the data of path
            }
            path.remove(path.size() - 1);
            return;
        }
        
        path.add(node.val);
        helper(node.left, path, cs + node.val, ts, res);
        helper(node.right, path, cs + node.val, ts, res);
        path.remove(path.size() - 1); //backtrack
    }
}
