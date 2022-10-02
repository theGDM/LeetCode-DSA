//O(3N) ~ O(N)
class Solution{
    void leftMostNodesWithoutLeaf(Node node, ArrayList<Integer> lmn){
        if(node == null){
            return;
        }
        
        if(node.left == null && node.right == null){ //ignore leaf node
            return;
        }
        
        //preorder me kaam
        lmn.add(node.data);
        
        if(node.left != null){
            leftMostNodesWithoutLeaf(node.left, lmn);
        }else{
            leftMostNodesWithoutLeaf(node.right, lmn);
        }
        
    }
    
    void reversedRightMostNodesWithoutNodes(Node node, ArrayList<Integer> rmn){
        if(node == null){
            return;
        }
        
        if(node.left == null && node.right == null){ //ignore leaf node
            return;
        }
        
        if(node.right != null){
            reversedRightMostNodesWithoutNodes(node.right, rmn);
        }else{
            reversedRightMostNodesWithoutNodes(node.left, rmn);
        }
        
        //postorder me kaam
        rmn.add(node.data);
    }
    
    void leafNodes(Node node, ArrayList<Integer> ln){
        if(node == null){
            return;
        }
    
        leafNodes(node.left, ln);
        
        if(node.left == null && node.right == null){
            ln.add(node.data); //inorder me add
        }
        
        leafNodes(node.right, ln);
    }
    
	ArrayList<Integer> boundary(Node node){
	    ArrayList<Integer> res = new ArrayList<>();
	    if(node == null){ //empty binary tree
	        return res;
	    }
	    
	    res.add(node.data);
	    if(node.left == null && node.right == null){ //leaf node
	        return res;
	    }
	    
	    //left most nodes without node and leaf
	    ArrayList<Integer> lmn = new ArrayList<>();
	    leftMostNodesWithoutLeaf(node.left, lmn);
	    
	    //leaf nodes
	    ArrayList<Integer> ln = new ArrayList<>();
	    leafNodes(node, ln);
	    
	    //right most nodes without node and leaf(reverse)
	    ArrayList<Integer> rmn = new ArrayList<>();
	    reversedRightMostNodesWithoutNodes(node.right, rmn);
	    
	    res.addAll(lmn);
	    res.addAll(ln);
	    res.addAll(rmn);
	    return res;
	}
}

class Solution{
    void leftMostNodesWithoutLeaf(Node node, ArrayList<Integer> lmn){
        if(node == null){
            return;
        }
        
        if(node.left == null && node.right == null){
            return;
        }
        
        //preorder me kaam
        lmn.add(node.data);
        
        if(node.left != null){
            leftMostNodesWithoutLeaf(node.left, lmn);
        }else{
            leftMostNodesWithoutLeaf(node.right, lmn);
        }
        
    }
    
    void reversedRightMostNodesWithoutNodes(Node node, ArrayList<Integer> rmn){
        if(node == null){
            return;
        }
        
        if(node.left == null && node.right == null){
            return;
        }
        
        if(node.right != null){
            reversedRightMostNodesWithoutNodes(node.right, rmn);
        }else{
            reversedRightMostNodesWithoutNodes(node.left, rmn);
        }
        
        //postorder me kaam
        rmn.add(node.data);
    }
    
    void leafNodes(Node node, ArrayList<Integer> ln){
        if(node == null){
            return;
        }
        
        if(node.left == null && node.right == null){
            ln.add(node.data);
            return;
        }
        
        leafNodes(node.left, ln);
        leafNodes(node.right, ln);
    }
    
	ArrayList<Integer> boundary(Node node){
	    ArrayList<Integer> res = new ArrayList<>();
	    if(node == null){ //empty binary tree
	        return res;
	    }
	    
	    res.add(node.data);
	    if(node.left == null && node.right == null){ //leaf node
	        return res;
	    }
	    
	    //left most nodes without node and leaf
	    ArrayList<Integer> lmn = new ArrayList<>();
	    leftMostNodesWithoutLeaf(node.left, lmn);
	    
	    //leaf nodes
	    ArrayList<Integer> ln = new ArrayList<>();
	    leafNodes(node, ln);
	    
	    //right most nodes without node and leaf(reverse)
	    ArrayList<Integer> rmn = new ArrayList<>();
	    reversedRightMostNodesWithoutNodes(node.right, rmn);
	    
	    res.addAll(lmn);
	    res.addAll(ln);
	    res.addAll(rmn);
	    return res;
	}
}
