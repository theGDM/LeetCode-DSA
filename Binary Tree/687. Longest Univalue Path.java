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
        boolean isBothChildEqualsParent = false;
        if(lp.val != null && rp.val != null){
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
        }else if(lp.val != null){
            if(lp.val == root.val){
                mp.depth = lp.depth + 1;
            }else{
                mp.depth = 0;
            }
        }else if(rp.val != null){
            if(rp.val == root.val){
                mp.depth = rp.depth + 1;
            }else{
                mp.depth = 0;
            }
        }else{ //both child is having null value, means leaf node return depth as 0
            mp.depth = 0;
        }
        
        //two different conditions
        if(isBothChildEqualsParent) max = Math.max(max, lp.depth + rp.depth + 2);
        else max = Math.max(max, mp.depth);
        
        mp.val = root.val;
        return mp;
    }
}
