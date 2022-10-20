/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

//TC : O(N)
//Using Pair method
public class Solution {
    /**
     * @param root: the given tree
     * @return: the number of uni-value subtrees.
     */
    public class Pair{
        boolean isUni;
        Integer val;
        int count;
    }

    public int countUnivalSubtrees(TreeNode root) {
        Pair ans = helper(root);
        return ans.count;
    }

    public Pair helper(TreeNode root){
        if(root == null){
            Pair bp = new Pair();
            bp.isUni = true; //A null node can be considered as uniValued
            bp.val = null;
            bp.count = 0;
            return bp;
        }

        Pair lp = helper(root.left);
        Pair rp = helper(root.right);

        Pair mp = new Pair();

        if(lp.val != null && rp.val != null){
            mp.isUni = lp.isUni && rp.isUni && root.val == lp.val && root.val == rp.val;
        }else if(lp.val != null){
            mp.isUni = lp.isUni &&  root.val == lp.val;
        }else if(rp.val != null){
            mp.isUni = rp.isUni &&  root.val == rp.val;
        }else{
            mp.isUni = true; //if both lp.val and rp.val is null, that means, curr node is leaf node
        }                    //which is always a univalued subtree

        if(mp.isUni == true){ //setting count of my pair
            mp.count = lp.count + rp.count + 1;
        }else{
            mp.count = lp.count + rp.count;
        }

        mp.val = root.val;
        return mp;
    }
}
