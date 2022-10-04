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
    //TC : O(n), SC : O(n)
    public void getInorder(TreeNode root, ArrayList<TreeNode> inorder){ //O(n)
        if(root == null) return;
        getInorder(root.left, inorder);
        inorder.add(root);
        getInorder(root.right, inorder);
    }
    
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> inorder = new ArrayList<>();
        getInorder(root, inorder);
        TreeNode first = null;
        TreeNode second = null;
        for(int i = 1; i < inorder.size(); ++i){ //O(n)
            if(inorder.get(i - 1).val > inorder.get(i).val){ 
                if(first == null){
                    first = inorder.get(i - 1);
                    second = inorder.get(i);
                }else{
                    second = inorder.get(i);
                }
            }
        }
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
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
class Solution {
    //TC : O(n), SC : O(n)
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void getInorder(TreeNode curr){ //O(n)
        if(curr == null) return;
        getInorder(curr.left);
        
        if(prev != null){
            if(prev.val > curr.val){
                if(first == null){
                    first = prev;
                    second = curr;
                }else{
                    second = curr;
                }
            }
        }
        prev = curr;
        
        getInorder(curr.right);
    }
    
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        getInorder(root);
    
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}

//Wrong, making of prev = curr, should be in inorder area
class Solution {
    //TC : O(n), SC : O(n)
    TreeNode first = null;
    TreeNode second = null;
    public void getInorder(TreeNode curr, TreeNode prev){ //O(n)
        if(curr == null) return;
        getInorder(curr.left, curr);
        
        if(prev != null){
            if(prev.val > curr.val){
                if(first == null){
                    first = prev;
                    second = curr;
                }else{
                    second = curr;
                }
            }
        }
        
        getInorder(curr.right, curr);
    }
    
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        getInorder(root, null);
    
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}

//Using Morrise Trvaresal
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
    //TC : O(n), SC : O(1)
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    
    public void recoverTree(TreeNode root) {
        TreeNode curr = root;
        
        while(curr != null){
            if(curr.left == null){ //No left subtree
                //print
                if(prev != null){
                    if(prev.val > curr.val){
                        if(first == null){
                            first = prev;
                            second = curr;
                        }else{
                            second = curr;
                        }
                    }
                }
                prev = curr;
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
                    //print
                    if(prev != null){
                        if(prev.val > curr.val){
                            if(first == null){
                                first = prev;
                                second = curr;
                            }else{
                                second = curr;
                            }
                        }
                    }
                    prev = curr;
                    iop.right = null; //break the link
                    curr = curr.right;
                }
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
