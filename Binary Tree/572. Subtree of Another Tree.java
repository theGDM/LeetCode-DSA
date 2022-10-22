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
//Worst Case TC : O(N * M), N -> num of nodes in root tree, M -> num of nodes in subRoot
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(isSame(root, subRoot)) return true; //same tree code
        
        boolean lans = isSubtree(root.left, subRoot); 
        if(lans) return true;
        
        boolean rans = isSubtree(root.right, subRoot);
        if(rans) return true;
        return false;
    }
    
    // If both nodes are non-empty, then they are identical only if
    // 1. Their values are equal
    // 2. Their left subtrees are identical
    // 3. Their right subtrees are identical       
    public boolean isSame(TreeNode s, TreeNode t){
        if(s == null && t == null) return true; //as boths nodes are null
        if(s == null || t == null) return false; //if any of the treenode is null return false
        
        if(s.val != t.val) return false;
        
        boolean lans = isSame(s.left, t.left);
        if(lans == false) return false;
        
        boolean rans = isSame(s.right, t.right);
        if(rans == false) return false;
        
        return true;
    }
}
