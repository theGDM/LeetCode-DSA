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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        Stack<TreeNode> mainStk = new Stack<>();
        Stack<TreeNode> childStk = new Stack<>();
        mainStk.add(root);
        int level = 1;
        
        while(mainStk.size() != 0){
            int size = mainStk.size();
            List<Integer> currLevel = new ArrayList<>();
            
            while(size-- > 0){
                TreeNode rnode = mainStk.pop();//remove
                currLevel.add(rnode.val);//our work
                
                if(level % 2 == 1){ //if level odd then fill childs of rnode from left to right
                    if(rnode.left != null){
                        childStk.push(rnode.left);
                    }
                    
                    if(rnode.right != null){
                        childStk.push(rnode.right);
                    }
                }else{ //if level even then fill childs of rnode from right to left
                    if(rnode.right != null){
                        childStk.push(rnode.right);
                    }
                    
                    if(rnode.left != null){
                        childStk.push(rnode.left);
                    }
                }
            }
            if(mainStk.size() == 0){
                mainStk = childStk; //now childStk becomes mainStk
                childStk = new Stack<>(); //
                ans.add(currLevel); //add current level AL in ans AL
                ++level; //update level
            }             
        }
        return ans;
    }
}
