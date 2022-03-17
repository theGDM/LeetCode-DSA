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
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
    
    public static void helper(Node node, List<Integer> ans){
        if(node == null){ //no tree
            return;
        }
        
        for(Node child : node.children){
            helper(child, ans); //faith calls
        }
        
        ans.add(node.val);//work in post region of current node;
    }
}
