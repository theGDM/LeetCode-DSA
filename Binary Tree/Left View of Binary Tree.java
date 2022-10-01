/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
//TC : O(n)
//SC : O(n)

class Tree{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root){
       if(root == null){ //important
           return new ArrayList<>();
       }
       
       ArrayList<Integer> res = new ArrayList<>();
       Queue<Node> q = new ArrayDeque<>();
       q.add(root);
       
       while(q.size() > 0){
           int size = q.size();
           res.add(q.peek().data);
           while(size-- > 0){
               Node rem = q.remove();
               
               if(rem.left != null){
                   q.add(rem.left);
               }
               
               if(rem.right != null){
                   q.add(rem.right);
               }
           }
       }
       
       return res;
    }
}
