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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        Queue<TreeNode> que = new ArrayDeque();
        que.add(root);
        int sum = 0;

        while(que.size() != 0){
            int size = que.size();

            while(size-- > 0){
                TreeNode rnode = que.remove();//remove
                
                if(rnode.left != null && rnode.left.left == null && rnode.left.right == null){
                    // System.out.println(rnode.left.val);
                    sum += rnode.left.val;
                    
                    if(rnode.right != null){//adding the right child of rnode if its not null
                        que.add(rnode.right);
                    }
                }else{
                    if(rnode.left != null){//adding the left child of rnode if its not null
                        que.add(rnode.left);
                    }
                    
                    if(rnode.right != null){//adding the right child of rnode if its not null
                        que.add(rnode.right);
                    } 
                }
                
            }
        }
        return sum;  
    }
}
