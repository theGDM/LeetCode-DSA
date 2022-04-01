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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val, null, null);//create and return new node, if right position is found
        }
        
        if(root.val > val){ //go to left subtree
            root.left = insertIntoBST(root.left, val); //receive the new node in current node's left
            return root; //and finally return the current node
        }else if(root.val < val){
            root.right = insertIntoBST(root.right, val);
            return root;
        }else{
            return root;
        }
    }
}
