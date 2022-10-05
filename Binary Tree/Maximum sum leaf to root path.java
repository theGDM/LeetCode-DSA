//TC : O(n), SC : O(1), if we ignore recursion call stack space
class Solution{
    public static int maxPathSum(Node root){
        if(root == null) return Integer.MIN_VALUE; //important to return -infinity
        
        if(root.left == null && root.right == null){
            return root.data;
        }
        
        int lans = maxPathSum(root.left); //max from left to one of the left leaves
        int rans = maxPathSum(root.right); //max from right to one of the right leaves
        int fans = Math.max(lans, rans) + root.data; //postorder me work
        return fans;
    }
}

//Other way
//TC : O(n), SC : O(1), if we ignore recursion call stack space
//faster
class Solution{
    public static int maxPathSum(Node root){
        if(root.left != null && root.right != null){
            int lans = maxPathSum(root.left); //max from left to one of the left leaves
            int rans = maxPathSum(root.right); //max from right to one of the right leaves
            return Math.max(lans, rans) + root.data; //postorder me work
        }else if(root.left != null){
            int lans = maxPathSum(root.left);
            return lans + root.data;
        }else if(root.right != null){
            int rans = maxPathSum(root.right);
            return rans + root.data;
        }else{ //leaf node case
            return root.data;
        }
    }
}
