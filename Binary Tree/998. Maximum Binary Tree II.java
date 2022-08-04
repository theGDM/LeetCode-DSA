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

//If the value is greater than the root value, it becomes the new root, and the old root becomes the left child (5 becomes the new root):
//Otherwise, the value needs to be inserted into the right subtree of the root. So we repeat this procedure recursively for the right subtree (4 is inserted into the right subtree, and becomes the new root of that subtree):
//why we are adding the node in the right?
//because question demanding us to append val to the list..
//a[1], a[2], a[3]...,a[i - 1], a[i], a[i + 1], a[i + 2], a[i + 3], a[i + 4],.....a[a.length - 1]
//a[i] is maximum among all, so if we append to the list, then it will always be to at the end, means
//in the right subtree..

class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null || val > root.val){
            TreeNode temp = new TreeNode(val);
            temp.left = root;
            temp.right = null;
            return temp; 
        }
        
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
