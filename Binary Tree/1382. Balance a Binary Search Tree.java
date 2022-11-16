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
//TC : O(n) + O(n)
//SC : O(n) //n is the number of nodes
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        if(root == null) return null;
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder); //get list in sorted order
        return constructBST(0, inorder.size() - 1, inorder); //now construct the BST, from array
    }
    
    public TreeNode constructBST(int lo, int hi, ArrayList<Integer> list){
        if(lo > hi) return null;//base case
        int mid = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = constructBST(lo, mid - 1, list);
        node.right = constructBST(mid + 1, hi, list);
        return node;
    }
    
    public void getInorder(TreeNode root, ArrayList<Integer> inorder){ //O(n)
        if(root == null) return;
        getInorder(root.left, inorder);
        inorder.add(root.val);
        getInorder(root.right, inorder);
    }
}
