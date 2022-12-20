//TC : O(N) + O(N)
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        HashSet<Integer> unique = new HashSet<>();
        dfs(root, unique);
        
        //The first minimum must be root.val
        int min1 = root.val;
        long min2 = Long.MAX_VALUE;
        for(int val : unique){
            if(min1 < val && val < min2){
                min2 = val;
            }
        }
        
        return min2 == Long.MAX_VALUE ? -1 : (int)min2;
    }
    
    public void dfs(TreeNode root, HashSet<Integer> unique){
        if(root == null) return;
        
        unique.add(root.val);
        dfs(root.left, unique);
        dfs(root.right, unique);
    }
}

//TC : O(N)
//AD-hoc
class Solution {
    int min1;
    long min2 = Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        min1 = root.val;
        dfs(root);
        return min2 == Long.MAX_VALUE ? -1 : (int)min2;
    }
    
    public void dfs(TreeNode root){
        if(root == null) return;
        
        if(min1 < root.val && root.val < min2){
            min2 = root.val;
        }else if(root.val == min1){
            dfs(root.left);
            dfs(root.right);
        }
    }
}
