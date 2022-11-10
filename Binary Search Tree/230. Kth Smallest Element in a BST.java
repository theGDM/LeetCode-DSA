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
        if(p != 0) dfs(root.left);

        p--;
        if(p == 0){
            ans = root.val;
            return;
        }
        
        if(p != 0) dfs(root.right);
    }
}

//Without static variables (fatster than 100%)
// 1.Taking advantage of the fact that the nodes have positive values only.
// 2. We do an inorder traversal. Left->Root->Right. When processing the root, increment the global processed nodes dec by 1.
// 3. As soon as count hits 'k', we have found the 'k'th smallest node. Return it.
// 4. Otherwise return -1 indicating that 'k'th smallest node has not yet been found
//smart call
class Solution {
    int pos;
    public int kthSmallest(TreeNode root, int k) {
        pos = k;
        return dfs(root);
    }
    
    public int dfs(TreeNode root){
        if(root == null) return -1; 
        
        int lans = dfs(root.left);
        if(lans >= 0){
            return lans;
        }
        
        pos--;
        if(pos == 0){
            return root.val;
        }
        
        int rans = dfs(root.right);
        if(rans >= 0){
            return rans;
        }
        
        return -1;
    }
}

//Now it is using the O(N) recursion call stack space, which we don't want,
//so we need to go for morris traversal
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int pos = 0;
        TreeNode curr = root;
        int ans = root.val;
        while(curr != null){
            if(curr.left == null){ //No left subtree
                pos++;
                //printing area
                if(pos == k){
                    ans = curr.val;
                    break;
                }
                
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
                    //printing area
                    pos++;
                    if(pos == k){
                        ans = curr.val; 
                        break;
                    }
                    iop.right = null; //break the link
                    curr = curr.right;
                }
            }
        }
        
        return ans;
    }  
}
