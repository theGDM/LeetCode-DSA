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
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        //getPreorder O(n)
        ArrayList<Integer> pre = new ArrayList<>();
        getPreorder(root, pre);
        
        //make tree O(n)
        TreeNode temp = makeTree(pre, 0);
        root.right = temp.right; //deep copy
        root.left = null;
    }
    
    public TreeNode makeTree(ArrayList<Integer> pre, int idx){
        if(idx == pre.size()){
            return null;
        }
        
        TreeNode right = makeTree(pre, idx + 1);
        TreeNode newNode = new TreeNode(pre.get(idx)); //make new treenode
        newNode.right = right; //make its right child as the coming newNode
        newNode.left = null; //make its left child as null
        return newNode;
    }
    
    public void getPreorder(TreeNode root, ArrayList<Integer> pre){
        if(root == null) return;
        
        pre.add(root.val);
        getPreorder(root.left, pre);
        getPreorder(root.right, pre);
    }
}

//optimized solution O(n)
class Solution {
    public TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        flatten(root.right);
        flatten(root.left);
        
        //postorder work
        root.right = prev;
        root.left = null;
        prev = root;
    }
}

