//Root to Node
//TC : O(n), SC : O(1), if we ignore recursion call stack space
//Travel and Change approach
class Solution{
    public static int max;
    public static int maxPathSum(Node root){
        max = Integer.MIN_VALUE;
        helper(root, 0);
        return max;
    }
    
    public static void helper(Node root, int csum){
        if(root == null) return;
        
        if(csum + root.data > max){
            max = csum + root.data;
        }
        
        helper(root.left, csum + root.data);
        helper(root.right, csum + root.data);
    }
}

//Root to Node
//TC : O(n), SC : O(1), if we ignore recursion call stack space
class Solution{
    public static int maxPathSum(Node root){
        if(root == null) return 0; 
        
        int lans = maxPathSum(root.left); //max from left to one of the left nodes
        int rans = maxPathSum(root.right); //max from right to one of the right nodes
        int maxlr = Math.max(lans, rans);//max between ans from left and right, if its is negative than retun root node data only
        if(maxlr < 0){
            return root.data;
        }else{
            return maxlr + root.data;
        }
    }
}

//Root to Node
//TC : O(n), SC : O(1), if we ignore recursion call stack space
class Solution{
    public static int maxPathSum(Node root){
        if(root == null) return 0; 
        
        int lans = maxPathSum(root.left); //max from left to one of the left nodes
        int rans = maxPathSum(root.right); //max from right to one of the right nodes
        
        int lans_dash = Math.max(0, lans);
        int rans_dash = Math.max(0, rans);
        
        return Math.max(lans_dash, rans_dash) + root.data;
    }
}
