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
//Using Pair method
class Solution {
    public class Pair{
        Integer val;
        int depth;
    }
    
    int max;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }
    
    public Pair helper(TreeNode root){
        if(root == null){
            Pair bp = new Pair();
            bp.val = null;
            bp.depth = -1;
            
            return bp;
        }
        
        Pair lp = helper(root.left);
        Pair rp = helper(root.right);
        
        Pair mp = new Pair();
        
        if(lp.val != null && rp.val != null){
            if(lp.val == root.val && rp.val == root.val){
                mp.depth = Math.max(lp.depth, rp.depth) + 1;
                max = Math.max(max, lp.depth + rp.depth + 2);
            }else if(lp.val == root.val){
                mp.depth = lp.depth + 1;
                max = Math.max(max, mp.depth);
            }else if(rp.val == root.val){
                mp.depth = rp.depth + 1;
                max = Math.max(max, mp.depth);
            }else{
                mp.depth = 0;
                max = Math.max(max, mp.depth);
            }
        }else if(lp.val != null){
            if(lp.val == root.val){
                mp.depth = lp.depth + 1;
            }else{
                mp.depth = 0;
            }
            max = Math.max(max, mp.depth);
        }else if(rp.val != null){
            if(rp.val == root.val){
                mp.depth = rp.depth + 1;
            }else{
                mp.depth = 0;
            }
            max = Math.max(max, mp.depth);
        }else{
            mp.depth = 0;
            max = Math.max(max, mp.depth);
        }
        
        mp.val = root.val;
        return mp;
    }
}

//Little optimized
//TC : O(N)
//SC : O(N), considering recursion call stack space
//Using Pair method
class Solution {
    public class Pair{
        Integer val;
        int depth;
    }
    
    int max;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }
    
    public Pair helper(TreeNode root){
        if(root == null){
            Pair bp = new Pair(); //base pair
            bp.val = null;
            bp.depth = -1;
            
            return bp;
        }
        
        Pair lp = helper(root.left); //getting left pair
        Pair rp = helper(root.right); //getting right pair 
        
        Pair mp = new Pair(); //creating my pair
        boolean isBothChildEqualsParent = false;
        if(lp.val != null && rp.val != null){ //when both left and right child exist
            if(lp.val == root.val && rp.val == root.val){
                mp.depth = Math.max(lp.depth, rp.depth) + 1;
                isBothChildEqualsParent = true; //in this case parent value is same as that of both childs
            }else if(lp.val == root.val){
                mp.depth = lp.depth + 1;
            }else if(rp.val == root.val){
                mp.depth = rp.depth + 1;
            }else{
                mp.depth = 0;
            }
        }else if(lp.val != null){ //when only left child exist
            if(lp.val == root.val){
                mp.depth = lp.depth + 1;
            }else{
                mp.depth = 0;
            }
        }else if(rp.val != null){ //when only right child exist
            if(rp.val == root.val){
                mp.depth = rp.depth + 1;
            }else{
                mp.depth = 0;
            }
        }else{ //both child is having null value, means leaf node return depth as 0
            mp.depth = 0;
        }
        
        //two different conditions, for evaluating max
        if(isBothChildEqualsParent) max = Math.max(max, lp.depth + rp.depth + 2);
        else max = Math.max(max, mp.depth); //calculate max
        
        mp.val = root.val; //set my pair val as root value
        return mp;
    }
}

//TC : O(N)
//SC : O(N), considering recursion call stack space
// Without using pair
//in terms of nodes
class Solution {
    int max;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        
        max = 0;
        helper(root, -1);
        if(max > 0) max = max - 1; 
        return max;
    }
    
    public int helper(TreeNode root, int val){
        if(root == null){
           return 0;
        }
        
        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);
        
        max = Math.max(max, left + right + 1); //calculate answer
        
        if(root.val == val){
            return Math.max(left, right) + 1;
        }else{
            return 0;
        }        
    }
}
