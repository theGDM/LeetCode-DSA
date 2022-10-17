//TC : O(logn)
//SC : O(1)
class Solution{
    //Function to find the least absolute difference between any node
    //value of the BST and the given integer.
    public static int close; //closest value
    public static int minDiff; //min Difference netween k and closest value
    static int minDiff(Node root, int K) { 
        // Write your code here
        close = Integer.MAX_VALUE;
        minDiff = Integer.MAX_VALUE;
        helper(root, K);
        return minDiff;
    } 
    
    public static void helper(Node root, int k){
        if(root == null) return;
        if(Math.abs(root.data - k) < Math.abs(close - k)){
            close = root.data;
            minDiff =  Math.abs(root.data - k); //update min diff between k and root value
        }
        
        if(root.data > k){
            helper(root.left, k);
        }else if(root.data < k){
            helper(root.right, k);
        }else{
            close = root.data;
            minDiff = 0;
            return;
        }
    }
}

class Solution{
    //Function to find the least absolute difference between any node
    //value of the BST and the given integer.
    public static int minDiff; //min Difference netween k and closest value
    static int minDiff(Node root, int K) { 
        // Write your code here
        minDiff = Integer.MAX_VALUE;
        helper(root, K);
        return minDiff;
    } 
    
    public static void helper(Node root, int k){
        if(root == null) return;
        int diff = Math.abs(root.data - k);
        if(diff < minDiff){
            minDiff =  diff; //update min diff between k and root value
        }
        
        if(root.data > k){
            helper(root.left, k);
        }else if(root.data < k){
            helper(root.right, k);
        }else{
            return;
        }
    }
}
