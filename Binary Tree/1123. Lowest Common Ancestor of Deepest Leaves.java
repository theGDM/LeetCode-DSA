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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int depth = getDepth(root);
        ArrayList<TreeNode> list = new ArrayList<>();
        getNodesAtDepth(root, 1, depth, list);

        if(list.size() > 1){
            return LCA(root, list.get(0), list.get(list.size() - 1));
        }else{
            return list.get(0);
        }
    }
    
    //putting all the nodes at that level in arraylist
    public void getNodesAtDepth(TreeNode root, int cd, int d, ArrayList<TreeNode> list){ //O(n)
        if(root == null) return;
        if(cd == d){ //if current depth is equal to the depth of tree, then add those nodes
            list.add(root);
        }
        
        getNodesAtDepth(root.left, cd + 1, d, list);
        getNodesAtDepth(root.right, cd + 1, d, list);
    }
    
    //getting the depth of binary tree
    public int getDepth(TreeNode root){
        if(root == null) return 0;
        int lDepth = getDepth(root.left); //left depth
        int rDepth = getDepth(root.right); //right depth
        return Math.max(lDepth, rDepth) + 1;
    }
    
    //code for finding LCA of two nodes
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) { //O(n)
        if(root == null){
            return null;
        }
        
        if(root == p || root == q){
            return root;
        }
        
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        
        if(left != null && right != null){
            return root;
        }
        
        if(left != null){
            return left;
        }
        
        if(right != null){
            return right;
        }
        
        return null;
    }
}
