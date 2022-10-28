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
    int i = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        return createBT(traversal, 0);
    }
    
    public TreeNode createBT(String str, int depth){
        int countDash = 0;
        int j = i;
        while(j < str.length() && str.charAt(j) == '-'){ //couting the depth of node
            countDash++;
            j++;
        }
        
        if(countDash != depth){ 
            return null;
        }
        
        int start = j;
        while(j < str.length() && str.charAt(j) != '-'){ //calculating value
            j++;
        }
        
        int val = Integer.parseInt(str.substring(start, j)); //get the value
        i = j; // finally update i
        
        TreeNode node = new TreeNode(val); //make the treenode with found value
        node.left = createBT(str, depth + 1); //call for left child
        //if no left child, then no need for calling right child, matlab yadi left child nahi hai to right child 
        //bhi nahi hoga
        if(node.left != null){
            node.right = createBT(str, depth + 1); //call for right child
        }
        
        return node;
    }
}
