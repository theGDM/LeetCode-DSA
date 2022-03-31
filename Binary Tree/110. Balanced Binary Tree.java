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
//A tree will be balanced if it root node is balanced + root node's left child's subtree is balanced + 
//root node's left child's subtree is balanced
class Solution {
    public class balPair{
        boolean isBal;
        int height;
    }
    
    public boolean isBalanced(TreeNode root) {
        balPair res = helper(root);
        return res.isBal;
    }
    
    public balPair helper(TreeNode node){
        //base case
        if(node == null){
            balPair np = new balPair();
            np.isBal = true;
            np.height = -1;
            return np;
        }
        
        //faith calls
        balPair lp = helper(node.left);//left subtree of current node is balanced or not
        balPair rp = helper(node.right);//right subtree of current node is balanced or not
        
        //meeting expectation(creating current node answer)
        balPair curr = new balPair();
        curr.isBal = Math.abs(lp.height - rp.height) <= 1 && lp.isBal && rp.isBal;
        curr.height = Math.max(lp.height, rp.height) + 1;
        
        return curr;
    }
}
