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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }
        List<List<Integer>> ans = new ArrayList();
    
        Queue<TreeNode> que = new ArrayDeque();
        que.add(root);

        while(que.size() != 0){
            int size = que.size();
            List<Integer> level = new ArrayList<>();

            while(size-- > 0){
                TreeNode rnode = que.remove();//remove
                level.add(rnode.val);//our work
    
                if(rnode.left != null){//adding the left child of rnode if its not null
                    que.add(rnode.left);
                }
                
                if(rnode.right != null){//adding the right child of rnode if its not null
                    que.add(rnode.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
