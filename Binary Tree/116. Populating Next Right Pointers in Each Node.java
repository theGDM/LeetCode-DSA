/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
//TC : O(N)
//SC : O (1)
class Solution {
    public Node connect(Node root) {
        helper(root);
        return root;
    }
    
    public void helper(Node root){
        if(root == null) return;
        
        Node curr = root;
        while(curr != null){
            if(curr.left != null && curr.right != null){
                curr.left.next = curr.right;
            }
            
            if(curr.right != null && curr.next != null){ //curr.right == null, saves, when we are at leaf nodes
                curr.right.next = curr.next.left;        //and curr.next == null, when we are at rightmost node
            }
            curr = curr.next;
        }
        
        helper(root.left);
    }
}
