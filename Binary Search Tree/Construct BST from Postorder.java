//TC : O(N)
//SC : O(1)
class GFG{
    public static int index;
    public static Node constructTree(int post[],int n){
        index = post.length - 1;
        return helper(post, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public static Node helper(int[] post, int min, int max){
        if(index == -1) return null;
        if(post[index] < min || post[index] > max) return null;
        
        int val = post[index];
        index--; //finally increment the index
        Node node = new Node(val);
        node.right = helper(post, val, max);
        node.left = helper(post, min, val);
        return node;
    }
}
