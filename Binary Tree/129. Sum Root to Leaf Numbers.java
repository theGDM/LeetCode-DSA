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
class Solution {
    public int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, "");
        return sum;
    }
    
    public void helper(TreeNode node, String currSum){
        if(node == null){ //base case
            return;
        }
        
        if(node.left == null && node.right == null){
            currSum += node.val;//adding current node value
            sum += Integer.parseInt(currSum);
            return;
        }
        
        helper(node.left, currSum + node.val);//faith call
        helper(node.right, currSum + node.val);//faith call
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
//TC : O(N)
class Solution {
    public int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    
    public void helper(TreeNode node, int currSum){
        if(node == null){ //base case
            return;
        }
        
        if(node.left == null && node.right == null){
            currSum = currSum * 10 + node.val;//adding current node value
            sum += currSum;
            return;
        }
        
        helper(node.left, currSum * 10 + node.val);//faith call
        helper(node.right, currSum * 10 + node.val);//faith call
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
//TC : O(N)
class Solution {
    public int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, new StringBuilder());
        return sum;
    }
    
    public void helper(TreeNode node, StringBuilder currSum){
        if(node == null){ //base case
            return;
        }
        
        if(node.left == null && node.right == null){
            currSum.append(node.val);//adding current node value
            sum += Integer.parseInt(currSum.toString());
            currSum.deleteCharAt(currSum.length() - 1); //backtrack
            return;
        }
        
        currSum.append(node.val);
        helper(node.left, currSum);//faith call
        helper(node.right, currSum);//faith call
        currSum.deleteCharAt(currSum.length() - 1);  //backtrack
    }
}
