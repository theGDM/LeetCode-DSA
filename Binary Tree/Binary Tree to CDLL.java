//TC : O(N)
class Solution{ 
    //Function to convert binary tree into circular doubly linked list.
    Node bTreeToClist(Node root){
        return helper(root);
    }
    
    public Node helper(Node root){
        if(root == null) return null;
        
        Node lhead = helper(root.left);
        Node rhead = helper(root.right);
        
        Node oneNodeL = root; //one node list
        oneNodeL.left = oneNodeL.right = root;
        
        Node p1head = concat(lhead, oneNodeL); //part1
        Node p2head = concat(p1head, rhead); //part2(final list)
        
        return p2head;
    }
    
    public Node concat(Node h1, Node h2){ //O(1)
        if(h1 == null){
            return h2;
        }else if(h2 == null){
            return h1;
        }
        
        Node t1 = h1.left;
        Node t2 = h2.left;
        
        //connecting both with tail of first and head of second
        t1.right = h2;
        h2.left = t1;
        
        //making the circular dll
        t2.right = h1;
        h1.left = t2;
        
        return h1;
    }
}
