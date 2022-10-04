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
//SC : O(n), map
//Using LenR
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i){
            hm.put(inorder[i], i); //value ke corresponding uska index
        }
        TreeNode root = construct(0, postorder.length - 1, 0, inorder.length - 1, hm, postorder);
        return root;
    }
    
    public TreeNode construct(int post_lo, int post_hi, int in_lo, int in_hi, HashMap<Integer, Integer> hm, int[] post){
        if(post_lo > post_hi || in_lo > in_hi){
            return null;
        }
        
        TreeNode root = new TreeNode(post[post_hi]);
        int checkIdx = hm.get(post[post_hi]); //getting the index where the root, value is located in inorder array
        
        int lenR = in_hi - checkIdx; //len on left side, after finding root in inorder array
        root.left = construct(post_lo, post_hi - lenR - 1, in_lo, checkIdx - 1, hm, post);
        root.right = construct(post_hi - lenR, post_hi - 1, checkIdx + 1, in_hi, hm, post);
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
//Using lenL
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i){
            hm.put(inorder[i], i); //value ke corresponding uska index
        }
        TreeNode root = construct(0, postorder.length - 1, 0, inorder.length - 1, hm, postorder);
        return root;
    }
    
    public TreeNode construct(int post_lo, int post_hi, int in_lo, int in_hi, HashMap<Integer, Integer> hm, int[] post){
        if(post_lo > post_hi || in_lo > in_hi){
            return null;
        }
        
        TreeNode root = new TreeNode(post[post_hi]);
        int checkIdx = hm.get(post[post_hi]); //getting the index where the root, value is located in inorder array
        
        int lenL = checkIdx - in_lo; //len on left side, after finding root in inorder array
        root.left = construct(post_lo, post_lo + lenL - 1, in_lo, checkIdx - 1, hm, post);
        root.right = construct(post_lo + lenL, post_hi - 1, checkIdx + 1, in_hi, hm, post);
        return root;
    }
}
