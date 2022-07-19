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

//TC : O(n)
class Solution {
    public TreeNode bstHelper(int[] preorder, int start, int end){
        if(nodeIndex == preorder.length || preorder[nodeIndex] < start || preorder[nodeIndex] > end){
            return null;
        }
        
        //preorder node create
        int val = preorder[nodeIndex];
        nodeIndex++;
        TreeNode node = new TreeNode(val);
        
        node.left = bstHelper(preorder, start, val);
        node.right = bstHelper(preorder, val, end);
        
        return node;
    }
    
    int nodeIndex;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null){
            return null;
        }
        
        nodeIndex = 0;
        return bstHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
