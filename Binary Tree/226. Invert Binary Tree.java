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
//Expectation - invertTree(node) will give us the inverted binary tree rooted at node.
//faith 1 - left child of B.T. knows how to invert its left subtree
//faith 2 - right child of B.T. knows how to invert its right subtree
//meeting expectation - first we will store the address of root's left child on temp node varibale,
//then will update root's left child as root's right child, and root's right child as the root's left
//child(i.e temp)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){ //base case
            return null;
        }
        
        //faith calls
        TreeNode libt = invertTree(root.left);
        TreeNode ribt = invertTree(root.right);
        
        //meeting expectation in postorder
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        return root;
    }
}
