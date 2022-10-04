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
//One Way, Without using extra space
//More Than O(n) 
//SC : O(1)
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = construct(0, preorder.length - 1, 0, inorder.length, preorder, inorder);
        return root;
    }
    
    public TreeNode construct(int pre_lo, int pre_hi, int in_lo, int in_hi, int[] pre, int[] in){
        if(pre_lo > pre_hi || in_lo > in_hi){ //base case
            return null;
        }
        
        TreeNode root = new TreeNode(pre[pre_lo]);
        int checkIdx = 0;
        for(int i = 0; i < in.length; ++i){
            if(pre[pre_lo] == in[i]){
                checkIdx = i;
            }
        }
        
        int lenL = checkIdx - in_lo; //len on left side, after finding root in inorder array
        root.left = construct(pre_lo + 1, pre_lo + lenL, in_lo, checkIdx - 1, pre, in);
        root.right = construct(pre_lo + lenL + 1, pre_hi, checkIdx + 1, in_hi, pre, in);
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
//TC : O(n);
//SC : O(n)
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i){
            hm.put(inorder[i], i); //value ke corresponding uska index
        }
        TreeNode root = construct(0, preorder.length - 1, 0, inorder.length, preorder, hm);
        return root;
    }
    
    public TreeNode construct(int pre_lo, int pre_hi, int in_lo, int in_hi, int[] pre, HashMap<Integer, Integer> hm){
        if(pre_lo > pre_hi){
            return null;
        }
        
        TreeNode root = new TreeNode(pre[pre_lo]);
        int checkIdx = hm.get(pre[pre_lo]); //getting the index where the root, value is located in inorder array
        
        int lenL = checkIdx - in_lo; //len on left side, after finding root in inorder array
        root.left = construct(pre_lo + 1, pre_lo + lenL, in_lo, checkIdx - 1, pre, hm);
        root.right = construct(pre_lo + lenL + 1, pre_hi, checkIdx + 1, in_hi, pre, hm);
        return root;
    }
}
