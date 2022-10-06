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
//Brute Force
//TC : O(n2)
class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return count;
    }
    
    public void dfs(TreeNode root, int ts){ //O(n)
        if(root == null) return;
        
        helper(root, 0, ts); //O(n) work, treating every node as root, and running helper function
        //calls
        dfs(root.left, ts);
        dfs(root.right, ts);
    }
    
    public void helper(TreeNode root, long cs, int ts){ //O(n)
        if(root == null) return;
        
        if((long)root.val + cs == ts){ //important
            count++;
        }
        
        helper(root.left, cs + root.val, ts);
        helper(root.right, cs + root.val, ts);
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
//Using HashMap, Using the code idea from "subarray sum equals to k (LC 560)"
//TC : O(n)
//The path does not need to start or end at the root or a leaf, but it must go downwards
class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put(0l, 1);
        dfs(root, 0, targetSum, hm);
        return count;
    }
    
    public void dfs(TreeNode root, long cs, int ts, HashMap<Long, Integer> hm){
        if(root == null) return;
        
        cs += (long)root.val;
        Long remainingSum = cs - ts;
        if(hm.containsKey(remainingSum)){
            count += hm.get(remainingSum);
        }
        
        hm.put(cs, hm.getOrDefault(cs, 0) + 1);
        
        dfs(root.left, cs, ts, hm);
        dfs(root.right, cs, ts, hm);
        
        hm.put(cs, hm.getOrDefault(cs, 0) - 1); //postorder me remove the count one 1
    }
    
}
