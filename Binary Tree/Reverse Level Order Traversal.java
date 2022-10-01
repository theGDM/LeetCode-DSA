/* 
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Tree{
    public ArrayList<Integer> reverseLevelOrder(Node node) {
        if(node == null){
            return new ArrayList<>();
        }
        
        Queue<Node> q = new ArrayDeque<>();
        Stack<Integer> stk = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.add(node);
    
        while(q.size() != 0){
            Node rnode = q.remove();
            stk.add(rnode.data);
                
            if(rnode.right != null){
                q.add(rnode.right);
            }
                
            if(rnode.left != null){
                q.add(rnode.left);
            }
        }
        
        while(stk.size() != 0){
           ans.add(stk.pop());
        }
        
        return ans;
    }
}      
