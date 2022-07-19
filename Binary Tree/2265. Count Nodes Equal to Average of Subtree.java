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
    //kisi node ke postorder matlab bo parent hota hai  
    public class Pair{
        int total;
        int num;
        
        Pair(){}
        
        Pair(int total, int num){
            this.total = total;
            this.num = num;
        }
    }
    
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return count;
    }
    
    public Pair helper(TreeNode root){
        if(root == null){
            return new Pair(0 , 0);
        }
        
        Pair lp = helper(root.left);
        Pair rp = helper(root.right);
        
        int currTotal = lp.total + rp.total + root.val;
        int currNum = lp.num + rp.num + 1;
        Pair np = new Pair(currTotal, currNum);
        
        if(currTotal / currNum == root.val){
            count++;
        } 
        
        return np;
    }
}
