//TC : O(N)
//Either both value exist, or not exist or either of any exist in the binary tree
class Solution{ //Little faster
    //Function to return the lowest common ancestor in a Binary Tree.
    boolean f1, f2;
	public Node lca(Node root, int n1,int n2){
	    f1 = false;
	    f2 = false;
		Node lca = lcaBT(root, n1, n2);
		if(f1 && f2){
		    return lca;
		}else{ //if either or both node not found in tree than return null
		    return null;
		}
	}
	
	public Node lcaBT(Node root, int n1, int n2){
	    if(root == null){
	        return null;
	    }
	    
	    Node left = lcaBT(root.left, n1, n2);
	    Node right = lcaBT(root.right, n1, n2);
	    
	    if(root.data == n1){
	        f1 = true;
	        return root;
	    }else if(root.data == n2){
	        f2 = true;
	        return root;
	    }else if(left != null && right != null){
	        return root;
	    }else if(left != null){
	        return left;
	    }else if(right != null){
	        return right;
	    }else{ //if left and right both null, return null
	        return null;
	    }
	}
}

