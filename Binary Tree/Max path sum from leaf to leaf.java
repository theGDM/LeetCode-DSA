//TC : O(n)
class Solution{
    int max;
    int maxPathSum(Node root){ 
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    } 
    
    //it will return root to node max;
    public int dfs(Node root){
        if(root.left != null && root.right != null){
            int left = dfs(root.left);
            int right = dfs(root.right);
            if(left + root.data + right > max){ //updationg leaf to leaf max
                max = left + root.data + right;
            }
            
            return Math.max(left, right) + root.data; //dono path me se jo bhi max wahi jaayega, uper
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
