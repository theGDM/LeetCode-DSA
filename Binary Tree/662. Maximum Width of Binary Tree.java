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
//Using recursion
//TC : O(N)
class Solution {
    long maxWidth;
    HashMap<Integer, Pair> map;
    
    public class Pair{
        long min;
        long max;
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        maxWidth = 0;
        map = new HashMap<>();
        helper(root, 1, 1); //root, level, index;
        return (int)maxWidth;
    }
    
    public void helper(TreeNode root, int lvl, long idx){
        if(root == null) return;
        
        helper(root.left, lvl + 1, idx * 2);
        helper(root.right, lvl + 1, idx * 2 + 1);
        
        Pair p = null;
        if(map.containsKey(lvl) == false){
            p = new Pair();
            p.min = idx;
            p.max = idx;
            map.put(lvl, p);
        }else{
            p = map.get(lvl);
            p.max = idx; //only max will get updated with idx
        }
        
        long currWidth = p.max - p.min + 1;
        maxWidth = Math.max(maxWidth, currWidth);
    }
}


//Level Order
class Solution {
    public class Pair{
        TreeNode node;
        int idx;
        
        Pair(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 1));
        
        int level = 1;
        int maxWidth = Integer.MIN_VALUE;
        while(q.size() > 0){
            int size = q.size();
            int fIdx = 0; //first index
            int sIdx = 0; //second index
            boolean f = false; //boolean variable for setting sidx only once
            while(size-- > 0){
                Pair rem = q.remove();
                // System.out.print(rem.idx + " ");
                if(f == false && rem.node != null){ //setting first idx only one time
                    fIdx = rem.idx;
                    f = true;
                }
                
                if(rem.node != null){//changing second index till last non-null node
                    sIdx = rem.idx;
                }
                
                if(rem.node != null){
                    q.add(new Pair(rem.node.left, 2 * rem.idx));
                    q.add(new Pair(rem.node.right, 2 * rem.idx + 1));
                }
            }
          
            if(f == false) break;
            maxWidth = Math.max(maxWidth, sIdx - fIdx + 1);
        }
        
        return maxWidth;
    }
    
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        
        return Math.max(left, right) + 1;
    }
}


//TC : O(N)
//Level Order(More intuitive, without adding null node)
class Solution {
    public class Pair{
        TreeNode node;
        int idx;
        
        Pair(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 1));
        
        int level = 1;
        int maxWidth = Integer.MIN_VALUE;
        while(q.size() > 0){
            int size = q.size();
            int fIdx = 0; //first index
            int sIdx = 0; //second index
            boolean f = false; //boolean variable for setting sidx only once
            while(size-- > 0){
                Pair rem = q.remove();
                // System.out.print(rem.idx + " ");
                if(f == false && rem.node != null){ //setting first idx only one time
                    fIdx = rem.idx;
                    f = true;
                }
                
                if(rem.node != null){//changing second index till last non-null node
                    sIdx = rem.idx;
                }
                
                if(rem.node.left != null){
                    q.add(new Pair(rem.node.left, 2 * rem.idx));
                }
                
                if(rem.node.right != null){
                    q.add(new Pair(rem.node.right, 2 * rem.idx + 1));
                }
            }
          
            maxWidth = Math.max(maxWidth, sIdx - fIdx + 1);
        }
        
        return maxWidth;
    }
    
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        
        return Math.max(left, right) + 1;
    }
}
