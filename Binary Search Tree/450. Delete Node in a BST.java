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
    public int getJustSmaller(TreeNode root){
        if(root.right != null){
            return getJustSmaller(root.right);
        }else{
            return root.val;
        }
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        
        if(root.val > key){
            root.left = deleteNode(root.left, key);
            return root;
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
            return root;
        }else{//root.val == val
            //case 1
            if(root.left == null && root.right == null){
                return null;
            }
            
            //case 2
            if(root.left == null){
                return root.right;
            }
            
            if(root.right == null){
                return root.left;
            }
            
            //case 3
            int justSmaller = getJustSmaller(root.left); //get maximum value in left subtree of node that to be deleted
            root.val = justSmaller; //replace the value
            root.left = deleteNode(root.left, justSmaller); //now delete the node, from the left subtree, which became                                                             //the leaf node 
        }
        return root;
    }
}
