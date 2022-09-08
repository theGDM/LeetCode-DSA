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
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode curr = root;
        
        while(curr != null || stk.isEmpty() == false){
            while(curr != null){
                stk.push(curr);
                curr = curr.left;
            }
            
            TreeNode temp = stk.pop();
            res.add(temp.val);
            curr = temp.right;
        }
        
        return res;
    }
}
