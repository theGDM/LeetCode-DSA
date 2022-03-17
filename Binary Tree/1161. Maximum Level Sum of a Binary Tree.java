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
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }
    
        Queue<TreeNode> que = new ArrayDeque();
        que.add(root);
        int maxSum = Integer.MIN_VALUE;
        int ansLevel = 0;
        int currLevel = 0;

        while(que.size() != 0){
            int size = que.size();
            int levelSum = 0;
            ++currLevel;

            while(size-- > 0){
                TreeNode rnode = que.remove();//remove
                levelSum += rnode.val;//our work
                
    
                if(rnode.left != null){//adding the left child of rnode if its not null
                    que.add(rnode.left);
                }
                
                if(rnode.right != null){//adding the right child of rnode if its not null
                    que.add(rnode.right);
                }
            }
            if(levelSum > maxSum){//if level sum is greater than maxSum than we update the ansLevel
                maxSum = levelSum;
                ansLevel = currLevel;
            }
        }
        return ansLevel;
    }
}
