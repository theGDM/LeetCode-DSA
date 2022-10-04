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
