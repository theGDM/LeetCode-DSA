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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        
        while(stk.size() != 0){
            TreeNode rnode = stk.pop();
            ans.add(rnode.val);
            
            if(rnode.left != null){
                stk.push(rnode.left);
            }
            
            if(rnode.right != null){
                stk.push(rnode.right);
            }
        }
        
        Collections.reverse(ans); //reverse the answer
        
        return ans;
    }
}
