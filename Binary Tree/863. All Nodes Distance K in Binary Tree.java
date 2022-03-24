/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> nodeToRootPath(TreeNode node, TreeNode target){
        if(node == null){
            return new ArrayList<>();
        }
        
        if(node == target){
           List<TreeNode> base = new ArrayList<>();
           base.add(node);
           return base;
        }
        
        List<TreeNode> ls = nodeToRootPath(node.left, target);
        if(ls.size() > 0){
            ls.add(node);
            return ls;
        }
        
        List<TreeNode> rs = nodeToRootPath(node.right, target);
        if(rs.size() > 0){
            rs.add(node);
            return rs;
        }
        
        return new ArrayList<>();
    }
    
    public void kLevelDown(TreeNode node,  int k ,TreeNode blocker, List<Integer> part){
        if(node == null || node == blocker){
            return;
        }
        
        if(k == 0){
            part.add(node.val);
            return;
        }
        
        kLevelDown(node.left, k - 1, blocker, part);
        kLevelDown(node.right, k - 1, blocker, part);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> N2R = nodeToRootPath(root, target);
        List<Integer> allNodes = new ArrayList<>();
        
        for(int i = 0;i < N2R.size(); ++i){
            TreeNode blocker = i - 1 >= 0 ? N2R.get(i - 1) : null;
            List<Integer> part = new ArrayList<>();
            kLevelDown(N2R.get(i), k - i, blocker, part);
            allNodes.addAll(part);
        }
        
        return allNodes;
    }
}
