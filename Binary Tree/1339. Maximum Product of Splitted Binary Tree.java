// 1.) If we remove any edge of the Binary Tree, we can forms: a sub-tree and its complement.
// 2.) Firstly, we dfs to calculate the total sum of all nodes in the Binary Tree.
// 3.) Then, we dfs in post order to calculate sum of each sub-tree in the Binary Tree.
//         a.) If the sum of current sub-tree is currSum, then its complement is (totalSum - currSum).
//         b.) We update the answer if currSum * (totalSum - currSum) is greater than current answer.

class Solution {
    long maxProd;
    long MOD = (long)Math.pow(10, 9) + 7;
    public int maxProduct(TreeNode root) {
        maxProd = 1;
        int totalSum = getSum(root); //O(n) //To calculate total sum
        calculateMaxProd(root, totalSum); //O(n)
        return (int)(maxProd % MOD);
    }
    
    //Travel and Change Strategy
    public long calculateMaxProd(TreeNode root, int totalSum){
        if(root == null) return 0;
        long lsum = calculateMaxProd(root.left, totalSum);
        long rsum = calculateMaxProd(root.right, totalSum);
        long currSum = lsum + rsum + root.val;
        maxProd = Math.max(maxProd, currSum * (totalSum - currSum));
        return currSum;
    }
    
    //Calculate total sum of tree
    public int getSum(TreeNode root){
        if(root == null) return 0;
        int lsum = getSum(root.left);
        int rsum = getSum(root.right);
        int csum = lsum + rsum + root.val; //current sum
        return csum;
    }
}
