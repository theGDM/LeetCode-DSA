//TC : O(n)
//special case, Here Leaf node is a node which is connected to exactly one different node.
class Solution{
    int max;
    int maxPathSum(Node root){ 
        max = Integer.MIN_VALUE;
        
        if(root.left != null && root.right != null){
            dfs(root);
            return max;
        }else{
            int val = dfs(root);
            return Math.max(max, val);
        }
    } 
    
    //it will return root to node max;
    public int dfs(Node root){
        if(root.left != null && root.right != null){
            int left = dfs(root.left);
            int right = dfs(root.right);
            if(left + root.data + right > max){ //updationg left to left max
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
