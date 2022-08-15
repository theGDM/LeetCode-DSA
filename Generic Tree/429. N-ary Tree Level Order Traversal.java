By/*
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
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){ //no tree
            return new ArrayList();
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        
        while(q.size() != 0){
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            
            while(size-- > 0){
                Node rnode = q.remove();//remove
                level.add(rnode.val); //work
                
                //adding all the children of the rnode
                for(Node child : rnode.children){
                    q.add(child);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
