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
    public int tilt = 0;
    public int findTilt(TreeNode root) {
        helperSum(root);
        return tilt;
    }
    
    public int helperSum(TreeNode node){
        //travel and update strategy
        if(node == null){//base case
            return 0;
        }
        
        int ls = helperSum(node.left);//getting left tree sum rooted at current node
        int rs = helperSum(node.right);//getting right tree sum rooted at current node
        int ts = ls + rs + node.val;//adding current node value
        
        //post order work(adding current node's tilt to global tilt variable)
        if(ls > rs){
            tilt += ls - rs;
        }else{
            tilt += rs - ls;
        }
        
        return ts;
    }
}
