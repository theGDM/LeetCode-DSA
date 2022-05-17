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

class Solution {

    public TreeNode construct (int[] nums, int lo, int hi){
        if(lo > hi) //base case
            return null;
        //preorder task
        int mid = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(nums[mid]);//creation of treenode
        
        //faith calls
        TreeNode left = construct(nums, lo , mid - 1);
        TreeNode right = construct(nums, mid + 1, hi);
        
        //meeting expectaion
        node.left = left;
        node.right = right;
        return node;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }
}
