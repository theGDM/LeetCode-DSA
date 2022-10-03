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
//TC : O(n), SC : O(logn)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }
    
    public void inorder(TreeNode node, List<Integer> ans){
        if(node == null){ //no tree
            return;
        }
        
        //pre
        inorder(node.left, ans);
        //in
        ans.add(node.val);
        //post
        inorder(node.right, ans);
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
//TC : O(n), SC : O(H), Iterative
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode curr = root;
        
        while(curr != null || stk.isEmpty() == false){
            while(curr != null){
                stk.push(curr);
                curr = curr.left;
            }
            
            TreeNode temp = stk.pop();
            res.add(temp.val);
            curr = temp.right;
        }
        
        return res;
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
//Morrise Traversal
//TC : O(2n) , SC : O(1) No recursion and Iterative + O(1) sc
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
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
                    iop.right = curr; //make the thread 
                    curr = curr.left; 
                }else{ //left is processed
                    iop.right = null; //break the link
                    res.add(curr.val); //add to list
                    curr = curr.right;
                }
            }
        }
        
        return res;
    }
}
