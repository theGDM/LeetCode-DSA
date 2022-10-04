//TC : O(n), SC : O(1)
class Solution{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x){
        Node curr = root;
        boolean found = false;
        Node successor = null;
        while(curr != null){
            if(curr.left == null){ //No left subtree
                if(found == true){
                    successor = curr;
                    return successor;
                }
                
                if(curr == x){
                    found = true;
                }
                
                curr = curr.right; //go to right
            }else{
                Node iop = curr.left; //inorder predessor
                while(iop.right != null && iop.right != curr){
                    iop = iop.right;
                }
                
                if(iop.right == null){ //left is not processd
                    iop.right = curr; //make the thread 
                    curr = curr.left; 
                }else{ //left is processed
                    if(found == true){
                        successor = curr;
                        return successor;
                    }
                    
                    if(curr == x){
                        found = true;
                    }
                    
                    iop.right = null; //break the link
                    curr = curr.right;
                }
            }
        }
        
        return successor;
    }
}

//GFG Solution
//TC : O(n), SC : O(1)
class Solution{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x){
        Node successor = null;
        if(x.right != null){ //if x uper hota hai to
            successor = x.right;
            while(successor.left != null){
                successor = successor.left;
            }
            return successor;
        }
        
        while(root != null){
            if(x.data > root.data){
                root = root.right;
            }else if(x.data < root.data){
                successor = root;
                root = root.left;
            }else{
                break;
            }
        }
        
        return successor;
    }
}

//Using prev and curr
//TC : O(n), SC : O(1)
class Solution{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x){
        Node curr = root;
        Node successor = null;
        Node prev = null;
        while(curr != null){
            if(curr.left == null){ //No left subtree
                if(prev == x){
                    successor = curr;
                    return successor;
                }
                prev = curr;
                curr = curr.right; //go to right
            }else{
                Node iop = curr.left; //inorder predessor
                while(iop.right != null && iop.right != curr){
                    iop = iop.right;
                }
                
                if(iop.right == null){ //left is not processd
                    iop.right = curr; //make the thread 
                    curr = curr.left; 
                }else{ //left is processed
                    if(prev == x){
                        successor = curr;
                        return successor;
                    }
                    prev = curr;
                    iop.right = null; //break the link
                    curr = curr.right;
                }
            }
        }
        
        return successor;
    }
}
