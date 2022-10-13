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
//Using static variables
//TC : O(n)
//SC : O(n)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> inorder = new ArrayList<>();
        dfs(root, inorder);
        return inorder.get(k - 1);
    }
    
    public void dfs(TreeNode root, ArrayList<Integer> inorder){
        if(root == null) return;
        dfs(root.left, inorder);
        inorder.add(root.val);
        dfs(root.right, inorder);
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
//Using static variables
//TC : O(n)
class Solution {
    int p;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        p = k;
        ans = 0;
        dfs(root);
        return ans;
    }
    
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);

        p--;
        if(p == 0){
            ans = root.val;
            return;
        }
        
        dfs(root.right);
    }
}

//Without static variables
