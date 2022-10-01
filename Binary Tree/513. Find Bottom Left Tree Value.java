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
//Using BFS
//get last level ka first element(use left view of binaru tree code)
class Solution {
    public int findBottomLeftValue(TreeNode root) {
       if(root == null){
            return 0;
        }
        
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        while(q.size() > 0){
            int size = q.size();
            res.add(q.peek().val);
            while(size-- > 0){
                TreeNode rem = q.remove(); //remove
                
                //Add Nbrs
                if(rem.left != null){
                    q.add(rem.left);
                }
                
                if(rem.right != null){
                    q.add(rem.right);
                }
            }
        }
        
        return res.get(res.size() - 1);
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
//Faster than 100%
//No extra space
//Global Variable traverse and change strategy

class Solution {
    int depth = -1;
    int ans = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    
    public void dfs(TreeNode node, int lvl){
        if(node == null) return;
        
        if(lvl > depth){
            ans = node.val;
            depth = lvl;
        }
        
        dfs(node.left, lvl + 1);
        dfs(node.right, lvl + 1);
    }
}
