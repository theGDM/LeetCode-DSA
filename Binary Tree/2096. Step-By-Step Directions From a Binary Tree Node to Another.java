//TC : O(N) + O(N) + O(logN) + O(logN);
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<TreeNode> path1 = nodeToRootPath(root, startValue); //O(N), worst case
        List<TreeNode> path2 = nodeToRootPath(root, destValue); //O(N), worst case
        
        int i = path1.size() - 1;
        int j = path2.size() - 1;
        
        while(i >= 0 && j >= 0 && path1.get(i).val == path2.get(j).val){
            i--;
            j--;
        }
        
        StringBuilder res = new StringBuilder();
        while(i >= 0){
            res.append("U");
            i--;
        }
        
        TreeNode tempRoot = path2.get(j + 1); //LCA
        while(j >= 0){
            TreeNode currNode = path2.get(j);
            if(tempRoot.left == currNode){
                res.append("L");
            }else{
                res.append("R");
            }
            
            tempRoot = currNode; //change the root node as current node, for next node
            j--;
        }
        
        return res.toString();
    }
    
    
    //Node to root path code, TC : O(N), worst case
    public List<TreeNode> nodeToRootPath(TreeNode root, int val){
        if(root == null){
            return new ArrayList<>();
        }
        
        if(root.val == val){
            List<TreeNode> base = new ArrayList<>();
            base.add(root);
            return base;
        }
        
        List<TreeNode> left = nodeToRootPath(root.left, val);
        if(left.size() > 0){
            left.add(root);
            return left;
        }
        
        List<TreeNode> right = nodeToRootPath(root.right, val);
        if(right.size() > 0){
            right.add(root);
            return right;
        }
        
        return new ArrayList<>();
    }
}
