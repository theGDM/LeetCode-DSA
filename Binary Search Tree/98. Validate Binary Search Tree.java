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

//O(n) approach
class Solution {
    public void getInorder(TreeNode node, ArrayList<Integer> in){
        if(node == null){
          return;
        }

        getInorder(node.left, in);//pre area
        in.add(node.val);//in area
        getInorder(node.right, in);//post area
    }
    
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<>(); 
        getInorder(root, inorder);

        for(int i = 0;i < inorder.size() - 1; ++i){
            if(inorder.get(i) >= inorder.get(i + 1)){
              return false;
            }
        }

       return true;
    }
}

//TC : O(n2) Approach
class Solution {
  public Long max(TreeNode node){
    if(node == null){
      return Long.MIN_VALUE;
    }

    long lmax = max(node.left);
    long rmax = max(node.right);

    return Math.max(rmax, Math.max(lmax, node.val));
  }

  public Long min(TreeNode node){
    if(node == null){
      return Long.MAX_VALUE;
    }

    long lmin = min(node.left);
    long rmin = min(node.right);

    return Math.min(rmin, Math.min(lmin, node.val));
  }

  public boolean isValidBST(TreeNode root){
   if(root == null){
     return true;
   }
   
   if(root.left == null && root.right == null){
       return true;
   }
      
   long maxOfLeftSubTree = max(root.left);//getting max from left sub tree of current node
   long minOfRightSubTree = min(root.right);//getting min from right sub tree of current node

   boolean ltans = isValidBST(root.left);//getting ans from left sub tree of current node whether it is BST or not.
   boolean rtans = isValidBST(root.right);//getting ans from right sub tree of current node whether it is BST or not.

   //if currnt node + its left subtree + its right subtree are BST then return true otherwise false
   if((long)root.val > maxOfLeftSubTree && (long)root.val < minOfRightSubTree && ltans && rtans){
     return true;
   }
   return false;
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

//O(n) approach Using pair class
class Solution {
    public class BSTPair{
        boolean isBST;
        long max;
        long min;
    }
    
    public boolean isValidBST(TreeNode root) {
        BSTPair ans = helper(root);
        return ans.isBST;
    }
    
    public BSTPair helper(TreeNode root){
        if(root == null){
            BSTPair bp = new BSTPair();
            bp.max = Long.MIN_VALUE;
            bp.min = Long.MAX_VALUE;
            bp.isBST = true;
            
            return bp;
        }
        
        BSTPair lp = helper(root.left);
        BSTPair rp = helper(root.right);
        
        BSTPair curr = new BSTPair();
        curr.isBST = (long)root.val > lp.max && (long)root.val < rp.min && lp.isBST && rp.isBST;
        curr.max = Math.max(root.val, Math.max(lp.max, rp.max));
        curr.min = Math.min(root.val, Math.min(lp.min, rp.min));
        
        return curr;
    }
}
