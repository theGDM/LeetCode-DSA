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
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null){
            return false;
        }
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        int level = 0;
        while(q.size() > 0){
            int size = q.size();
            
            int prev = -1;
            while(size-- > 0){
                TreeNode rem = q.remove();
                
                //even level, have odd values in strictly increasing order
                if(level % 2 == 0){
                   if(rem.val % 2 == 0 || (prev != -1 && rem.val <= prev)){
                       return false;
                   }else{
                       prev = rem.val;
                   }
                }else if(level % 2 == 1){ //odd level, have even values in strictly dec order
                    if(rem.val % 2 == 1 || (prev != -1 && rem.val >= prev)){
                       return false;
                   }else{
                       prev = rem.val;
                   }
                }
                
                //add childs
                if(rem.left != null){
                    q.add(rem.left); 
                }
                
                if(rem.right != null){
                    q.add(rem.right);
                }
            }
            
            level++;
        }
        
        return true;
    }
}
