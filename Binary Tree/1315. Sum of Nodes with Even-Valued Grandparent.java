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
//DFS : O(n)
class Solution {
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        helper(root, null, null, 1);
        return sum;
    }
    
    public void helper(TreeNode r, TreeNode p, TreeNode gp, int level){
        if(r == null){ //base case
            return;
        }
        
        //grandparent is not there below level < 3
        if(level >= 3 && gp.val % 2 == 0){
            sum += r.val;
        }
        
        //now, current node will become the parent, and parent of current node
        //will become the grandparent of left and right child of current node.
        helper(r.left, r, p, level + 1); 
        helper(r.right, r, p, level + 1); 
    }
}

//BFS : O(n)
class Solution {
    public class Pair{
        TreeNode n;
        TreeNode p;
        TreeNode gp;
        
        Pair(TreeNode n, TreeNode p, TreeNode gp){
            this.n = n;
            this.p = p;
            this.gp = gp;
        }
    }
    
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, null, null));
        
        int level = 1;
        int sum = 0;
        
        while(q.size() > 0){
            int size = q.size();
            
            while(size-- > 0){
                //remove
                Pair curr = q.remove();
                
                //work
                if(level >= 3 && curr.gp.val % 2 == 0){
                    sum += curr.n.val;
                }
                
                //add childs
                if(curr.n.left != null){
                    q.add(new Pair(curr.n.left, curr.n, curr.p));
                }
                
                if(curr.n.right != null){
                    q.add(new Pair(curr.n.right, curr.n, curr.p));
                }
            }
            
            level++;
        }
        
        return sum;
    }
}
