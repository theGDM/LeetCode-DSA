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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    public TreeNode helper(int[] nums, int left, int right){
        if(left > right){ //-ve base case (return null)
            return null;
        }
        
        if(left == right){ //+ve base case (leaf node) 
            return new TreeNode(nums[left]);
        }
        
        int max = Integer.MIN_VALUE;
        int midx = 0; //index of maximum number in nums array
        
        for(int i = left; i <= right; ++i){
            if(nums[i] > max){
                max = nums[i];
                midx = i;
            }
        }
        
        TreeNode lst = helper(nums, left, midx - 1); //left subtree
        TreeNode rst = helper(nums, midx + 1, right); //right subtree
        
        //postorder work
        TreeNode node = new TreeNode(nums[midx]);
        node.left = lst;
        node.right = rst;
        
        return node;
    }
}
