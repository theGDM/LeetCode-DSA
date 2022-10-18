/*Complete the function below
Node is as follows:
class Tree{
	int data;
	Tree left,right,random;
	Tree(int d){
		data=d;
		left=null;
		right=null;
		random=null;
	}
}*/
//TC : O(3n)

class Solution{
    public Tree cloneTree(Tree tree){
       createDuplicates(tree);
       setRandoms(tree);
       return separateDuplicates(tree);
    }
    
    public void createDuplicates(Tree node){
        if(node == null) return;
        
        createDuplicates(node.left);
        createDuplicates(node.right);
        
        //postorder work
        Tree duplicate = new Tree(node.data);
        duplicate.left = node.left;
        duplicate.right = null;
        node.left = duplicate;
    }
    
    public void setRandoms(Tree node){
        if(node == null) return;
        
        setRandoms(node.left.left);
        setRandoms(node.right);
        
        //postorder work
        if(node.random != null){
            node.left.random = node.random.left;
        }
    }
    
    public Tree separateDuplicates(Tree node){
        if(node == null) return null;
        
        Tree leftDup = separateDuplicates(node.left.left);
        Tree rightDup = separateDuplicates(node.right);
        
        Tree dup = node.left;
        node.left = node.left.left;
        dup.left = leftDup;
        dup.right = rightDup;
        return dup;
    }
}
