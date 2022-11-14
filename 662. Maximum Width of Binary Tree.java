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
class Solution {
    public class Pair{
        TreeNode node;
        int idx;
        
        Pair(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 1));
        
        int level = 1;
        int maxWidth = Integer.MIN_VALUE;
        while(q.size() > 0){
            int size = q.size();
            int fIdx = 0; //first index
            int sIdx = 0; //second index
            boolean f = false; //boolean variable for setting sidx only once
            while(size-- > 0){
                Pair rem = q.remove();
                if(f == false && rem.node != null){ //setting first idx only one time
                    fIdx = rem.idx;
                    f = true;
                }
                
                if(rem.node != null){//changing second index till last non-null node
                    sIdx = rem.idx;
                }
                
                //adding the childs with index
                if(rem.node != null){
                    q.add(new Pair(rem.node.left, 2 * rem.idx));
                    q.add(new Pair(rem.node.right, 2 * rem.idx + 1));
                }
            }
            
            if(f == false) break;
            maxWidth = Math.max(maxWidth, sIdx - fIdx + 1);
        }
        
        return maxWidth;
    }
}
