//TC : O(n)
//special case, root is that node, which have exactly one parent
class Solution{
    int max;
    int maxPathSum(Node root){ 
        max = Integer.MIN_VALUE;
        
        if(root.left != null && root.right != null){
            dfs(root);
            return max;
        }else{ //this is the case when root is also the leaf
            int val = dfs(root);
            return Math.max(max, val);
        }
    } 
    
    //it will return root to leaf max;
    public int dfs(Node root){
        if(root.left != null && root.right != null){
            int left = dfs(root.left);
            int right = dfs(root.right);
            if(left + root.data + right > max){ //updationg leaf to leaf max
                max = left + root.data + right;
            }
            return Math.max(left, right) + root.data;
        }else if(root.left != null){
            int left = dfs(root.left);
            return root.data + left;
        }else if(root.right != null){
            int right = dfs(root.right);
            return root.data + right;
        }else{
            return root.data;
        }
    }
}
