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
    public TreeNode parx;
    public TreeNode pary;
    public int levelx;
    public int levely;
    
    public void levelOrderTraversal(TreeNode node, int x, int y){
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(node);
        int level = 1;
        
        while(que.size() != 0){
            int size = que.size();
            
            while(size-- > 0){
                TreeNode rnode = que.remove();
                
                if(rnode.left != null){
                    if(rnode.left.val == x){
                        parx = rnode;
                        levelx = level + 1;
                    }
                    
                    if(rnode.left.val == y){
                        pary = rnode;
                        levely = level + 1;
                    }
                    que.add(rnode.left);
                }
                
                if(rnode.right != null){
                    if(rnode.right.val == x){
                        parx = rnode;
                        levelx = level + 1;
                    }
                    
                    if(rnode.right.val == y){
                        pary = rnode;
                        levely = level + 1;
                    }
                    que.add(rnode.right);
                }
            }
            ++level;
        }
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){ //no tree
            return false;
        }
        
        if(x == root.val && y == root.val){ //one node
            return false;
        }
        
        levelOrderTraversal(root, x, y); //find parent of x and y and there respective level
        
        if(parx != pary && levelx == levely){
            return true;
        }
        
        return false;
    }
}
