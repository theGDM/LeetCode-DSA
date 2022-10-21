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
        int nodes;
        int coins;
    }
    
    public int moves;
    public int distributeCoins(TreeNode root) {
        moves = 0;
        helper(root);
        return moves;
    }
    
    public Pair helper(TreeNode root){
        if(root == null){
            Pair bp = new Pair();//base pair
            bp.nodes = 0;
            bp.coins = 0;
            return bp;
        }
        
        Pair lp = helper(root.left);
        Pair rp = helper(root.right);
        
        Pair mp = new Pair();
        mp.nodes = lp.nodes + rp.nodes + 1; //total nodes
        mp.coins = lp.coins + rp.coins + root.val; //total coins
        moves += Math.abs(mp.nodes - mp.coins); //absolue difference
        
        return mp;
    }
}

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
    public int moves;
    public int distributeCoins(TreeNode root) {
        moves = 0;
        helper(root);
        return moves;
    }
    
    public int helper(TreeNode root){
        if(root == null) return 0;
        
        int L = helper(root.left); //excess / deficit from left
        int R = helper(root.right); //excess / deficit from right
        
        moves += Math.abs(L) + Math.abs(R); //no of moves
        return root.val + L + R - 1;
    }
}
