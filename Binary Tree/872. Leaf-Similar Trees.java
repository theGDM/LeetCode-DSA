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

//here we are first finding the leaf nodes of the both tree and then comparing
//the both the arraylist
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> firstTreeLeaf = leafNodes(root1);//leaf of first b.t.
        ArrayList<Integer> secondTreeLeaf = leafNodes(root2);//leaf of second b.t.
        
        if(firstTreeLeaf.size() != secondTreeLeaf.size()){//if they are of diffrent size return false
            return false;
        }
        
        for(int i = 0; i < firstTreeLeaf.size(); ++i){
            if(firstTreeLeaf.get(i) != secondTreeLeaf.get(i)){
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<Integer> leafNodes(TreeNode node){
        if(node == null){ //if no tree present
            return new ArrayList<>();
        }
        
        //base case
        if(node.left == null && node.right == null){
            ArrayList<Integer> base = new ArrayList<>();
            base.add(node.val);
            return base;
        }
        
        //faith calls
        ArrayList<Integer> leaf = new ArrayList<>();
        ArrayList<Integer> lc = leafNodes(node.left);
        ArrayList<Integer> rc = leafNodes(node.right);
        
        //postorder work(adding all leaf nodes in leaf AL)
        for(int val : lc){ leaf.add(val); }
        for(int val : rc){ leaf.add(val); }
        
        return leaf;
    }
}
