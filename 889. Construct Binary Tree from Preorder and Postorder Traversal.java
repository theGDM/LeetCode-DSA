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
//TC : O(N), as using map
//All the values of preorder and postorder are unique.
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < postorder.length; ++i){
            map.put(postorder[i], i);
        }
        
        return helper(preorder, map, 0, preorder.length - 1, 0, postorder.length - 1);
    }
    
    public TreeNode helper(int[] pre, HashMap<Integer, Integer> map, int prelo, int prehi, int postlo, int posthi){
        if(prelo > prehi || postlo > posthi){//important pre : [2, 1], post : [1, 2]
            return null;
        }
        
        TreeNode root = new TreeNode(pre[prelo]);
        if(prelo + 1 <= prehi){
            int sidx = map.get(pre[prelo + 1]);
            int lhs = sidx - postlo + 1;
            
            root.left = helper(pre, map, prelo + 1, prelo + lhs, postlo, sidx);
            root.right = helper(pre, map, prelo + lhs + 1, prehi, sidx + 1, posthi - 1);
        }

        return root;
    }
}
