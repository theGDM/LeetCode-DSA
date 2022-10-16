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

//TC : O(nlog(n)) ~ worst case : O(n * n) //eg 5, 6, 7, 8, 9, 10
class Solution {
    public TreeNode addInBst(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }
        
        if(val < root.val){
            root.left = addInBst(root.left, val);
            return root;
        }else if(val > root.val){
            root.right = addInBst(root.right, val);
            return root;
        }else{
            return root;
        }
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        
        for(int i = 1; i < preorder.length; ++i){
            addInBst(root, preorder[i]);
        }
        
        return root;
    }
}

//TC : O(n)
//SC : O(n)
class Solution {
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public TreeNode helper(int[] pre, int min, int max){
        if(index == pre.length) return null;
        if(pre[index] < min || pre[index] > max) return null;
        
        int val = pre[index];
        index++; //fianlly increment the index
        TreeNode node = new TreeNode(val);
        node.left = helper(pre, min, val);
        node.right = helper(pre, val, max);
        return node;
    }
}
