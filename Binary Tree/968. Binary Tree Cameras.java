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
//TC : O(N)
//SC : O(1)
class Solution {
    final private int NOT_MONITORED = 1;
    final private int MONITORED = 2;
    final private int CAMERA = 3;
    public int count = 0;
    public int minCameraCover(TreeNode root) {
        if(root == null) return 0; //a null node is always monitored
        int top = helper(root);
        return top == NOT_MONITORED ? count + 1 : count;
    }
    
    public int helper(TreeNode root){
        if(root == null) return MONITORED;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        if(left == NOT_MONITORED || right == NOT_MONITORED){
            count++; //need camera in this case, place camera on this node
            return CAMERA;
        }else if(left == CAMERA || right == CAMERA){ //you are already monitored
            return MONITORED;
        }else{ //left == MONITORED || right == MONITORED
            return NOT_MONITORED;
        }
    }
}
