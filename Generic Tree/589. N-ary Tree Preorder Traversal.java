/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
    
    public static void helper(Node root, List<Integer> ans){
        if(root == null){
            return;
        }
        
        ans.add(root.val); //preorder work
        for(Node child : root.children){ //faith call on subtree rooted on children of root
            helper(child, ans);
        }
    }
}
