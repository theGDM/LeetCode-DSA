//TC : O(N1 + N2) ~ Linear time complexity
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        
        t1.val += t2.val; //update the value, of t1 node, by adding the value of t2 node
        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);
        
        //update the left and right childs of t1 node
        t1.left = left;
        t1.right = right;
        
        return t1;
    }
}

//without altering any original trees
//TC : O(N1 + N2) ~ Linear time complexity
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        
        TreeNode node = new TreeNode(t1.val + t2.val);
        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);
        
        //update the left and right childs of t1 node
        node.left = left;
        node.right = right;
        
        return node;
    }
}
