//O(N)
 //important trick for question having mirron concept, run two recursion, in same function
 class Solution {
    long ans = 0l;
    long MOD = 1000000007;
    public long imgMultiply(Node root){
        ans = (root.data * root.data) % MOD;
        helper(root.left, root.right);
        return ans;
    }
    
    public void helper(Node n1, Node n2){
        if(n1 == null || n2 == null) return;
        
        ans = (ans + n1.data * n2.data) % MOD;
        helper(n1.left, n2.right);
        helper(n1.right, n2.left);
    }
}
