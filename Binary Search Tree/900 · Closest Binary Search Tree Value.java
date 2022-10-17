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
//Without static variable
public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    //fastest
    //TC : O(logn)
    public int closestValue(TreeNode root, double target) {
        return (int)helper(root, target);
    }

    public static long helper(TreeNode root, double k){
        if(root == null) return Long.MAX_VALUE;
        
        if(root.val > k){
            long lans = helper(root.left, k);
            if(Math.abs(lans - k) < Math.abs(root.val - k)) return lans;
            else return root.val;
        }else if(root.val < k){
            long rans = helper(root.right, k);
            if(Math.abs(rans - k) < Math.abs(root.val - k)) return rans;
            else return root.val;
        }else{
            return root.val;
        }
    }
}
