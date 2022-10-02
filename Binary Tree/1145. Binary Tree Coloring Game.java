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
//idea -  we have to block the possible ways by which player p1 can choose nodes
class Solution {
    int xLeftST; //x node ki jo left subtree hai uska size
    int xRightST; //x node ki right subtree hai uska size
    
    public int size(TreeNode node, int x){
        if(node == null) return 0;
        
        int ls = size(node.left, x);
        int rs = size(node.right, x);
        
        if(node.val == x){
            xLeftST = ls;
            xRightST = rs;
        }
        
        int ts = ls + rs + 1;
        return ts;
    }
    
    //TC : O(n), SC : O(n)
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        size(root, x); //O(n)
        int theOtherSide = n - (xLeftST + xRightST + 1);
        int maxOfThree = Math.max(theOtherSide, Math.max(xLeftST, xRightST)); //left, right, parent ke size ka max | p2 will spred on these nodes
        int rest = n - maxOfThree; //remaining nodes, that p1 will spred on
        
        if(maxOfThree > rest){
            return true; //p2 will win
        }else{
            return false; //p1 will win
        }
    }
}
