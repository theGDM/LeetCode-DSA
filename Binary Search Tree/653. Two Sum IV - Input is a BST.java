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
//TC : O(n), Using Inorder property of BST
//SC : O(1), if we ignore the recursion call stack
//We are given strictly increasing BST, so no chance for duplicate elements
class Solution {
    HashMap<Integer, Integer> map;
    public boolean findTarget(TreeNode root, int k) {
        map = new HashMap<>();
        return helper(root, k);
    }
    
    public boolean helper(TreeNode root, int k){
        if(root == null) return false;
        
        boolean lans = helper(root.left, k);
        if(lans){
            return true;
        }
        
        int remSum = k - root.val;
        if(map.containsKey(remSum) == true){
            return true;
        }else{
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        }    
        
        boolean rans = helper(root.right, k);
        if(rans){
            return true;
        }
        
        return false;
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
//TC : O(n), Using Inorder property of BST
//SC : O(1), if we ignore the recursion call stack
//We are given strictly increasing BST, so no chance for duplicate elements
class Solution {
    HashSet<Integer> set;
    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        return helper(root, k);
    }
    
    public boolean helper(TreeNode root, int k){
        if(root == null) return false;
        
        boolean lans = helper(root.left, k);
        if(lans){
            return true;
        }
        
        int remSum = k - root.val;
        if(set.contains(remSum) == true){
            return true;
        }else{
            set.add(root.val);
        }    
        
        boolean rans = helper(root.right, k);
        if(rans){
            return true;
        }
        
        return false;
    }
}
