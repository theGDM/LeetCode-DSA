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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }
    
    public void preorder(TreeNode node, List<Integer> ans){
        if(node == null){ //no tree
            return;
        }
        
        //pre
        ans.add(node.val);
        preorder(node.left, ans);
        //post
        preorder(node.right, ans);
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
//left side me jaane se pahle list me add kara do
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        
        while(curr != null){
            if(curr.left == null){ //No left subtree
                res.add(curr.val); //add to list
                curr = curr.right; //go to right
            }else{
                TreeNode iop = curr.left; //inorder predessor
                while(iop.right != null && iop.right != curr){
                    iop = iop.right;
                }
                
                if(iop.right == null){ //left is not processd
                    res.add(curr.val); //add to list
                    iop.right = curr; //make the thread 
                    curr = curr.left; 
                }else{ //left is processed
                    iop.right = null; //break the link
                    curr = curr.right;
                }
            }
        }
        
        return res;
    }
    
}
