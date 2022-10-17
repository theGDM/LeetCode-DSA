/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
//TC : O(logn)
public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public static long close; //closest value
    public int closestValue(TreeNode root, double target) {
        close = Long.MAX_VALUE;
        helper(root, target);
        return (int)close;
    }

    public static void helper(TreeNode root, double k){
        if(root == null) return;
        if(Math.abs(root.val - k) < Math.abs(close - k)){
            close = root.val;
        }
        
        if(root.val > k){
            helper(root.left, k);
        }else if(root.val < k){
            helper(root.right, k);
        }else{
            close = root.val;
            return;
        }
    }
}
