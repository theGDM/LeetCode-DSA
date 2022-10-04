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
//TC : O(log(n) * log(n))
class Solution {
    public int heightl(TreeNode node){
        if(node == null) return 0;
        return heightl(node.left) + 1;
    }
    
    public int heightr(TreeNode node){
        if(node == null) return 0;
        return heightr(node.right) + 1;
    }
    
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int lh = heightl(root.left); //Log(n), as height is logn
        int rh = heightr(root.right); //Log(n)
        
        if(lh == rh){
            int ht = lh + 1;
            return (int)Math.pow(2, ht) - 1;
        }
        
        int lc = countNodes(root.left);
        int rc = countNodes(root.right);
    
        return lc + rc + 1;
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
//TC : O(log(n) * log(n))
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int lh = 0;
        TreeNode node = root.left;
        while(node != null){
            node = node.left;
            lh++;
        }
        
        int rh = 0;
        node = root.right;
        while(node != null){
            node = node.right;
            rh++;
        }
        
        if(lh == rh){
            int ht = lh + 1;
            return (1 << ht) - 1; //as we know 1 << 5 = 2^5
        }else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
} 
