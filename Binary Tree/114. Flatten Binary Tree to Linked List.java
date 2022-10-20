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
}//TC : O(N)
class Solution {
    public class Pair{
        TreeNode head;
        TreeNode tail;
        
        Pair(TreeNode head, TreeNode tail){
            this.head = head;
            this.tail = tail;
        }
    }
    
    public void flatten(TreeNode root) {
        if(root != null){
            helper(root);
        }
    }
    
    public Pair helper(TreeNode root){
        if(root.left != null && root.right != null){
            Pair lp = helper(root.left);
            Pair rp = helper(root.right);
            
            root.left = null;
            root.right = lp.head;
            lp.tail.right = rp.head;
            
            Pair mp = new Pair(root, rp.tail);
            return mp;
        }else if(root.left != null){
            Pair lp = helper(root.left);
            root.left = null;
            root.right = lp.head;
            
            Pair mp = new Pair(root, lp.tail); 
            return mp;
        }else if(root.right != null){
            Pair rp = helper(root.right);
            
            Pair mp = new Pair(root, rp.tail); 
            return mp;
        }else{
            Pair mp = new Pair(root, root);
            return mp;
        }
    }
}

//TC : O(N)
//Pair Method
class Solution {
    public class Pair{
        TreeNode head;
        TreeNode tail;
        
        Pair(TreeNode head, TreeNode tail){
            this.head = head;
            this.tail = tail;
        }
    }
    
    public void flatten(TreeNode root) {
        if(root != null){
            helper(root);
        }
    }
    
    public Pair helper(TreeNode root){
        if(root.left != null && root.right != null){
            Pair lp = helper(root.left);
            Pair rp = helper(root.right);
            
            root.left = null;
            root.right = lp.head;
            lp.tail.right = rp.head;
            
            Pair mp = new Pair(root, rp.tail);
            return mp;
        }else if(root.left != null){
            Pair lp = helper(root.left);
            root.left = null;
            root.right = lp.head;
            
            Pair mp = new Pair(root, lp.tail); 
            return mp;
        }else if(root.right != null){
            Pair rp = helper(root.right);
            
            Pair mp = new Pair(root, rp.tail); 
            return mp;
        }else{
            Pair mp = new Pair(root, root);
            return mp;
        }
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
//TC : O(N)
class Solution {
    public TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        TreeNode ol = root.left;
        TreeNode or = root.right;
            
        if(prev != null){ //doing in preorder(transformation)
            prev.left = null;
            prev.right = root; //as preveious is one step behind of root
        }
        prev = root;
        
        flatten(ol);
        flatten(or);
    }
}
