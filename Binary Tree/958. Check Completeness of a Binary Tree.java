//TC : O(n) + O(n + m)
class Solution {
    public class Pair{
        TreeNode node;
        int lvl;
        
        Pair(TreeNode node, int lvl){
            this.node = node;
            this.lvl = lvl;
        }
    }
    
    public boolean isCompleteTree(TreeNode root) {
        int level = getHeight(root); //getting the total height of tree

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 1));
        
        while(q.size() > 0){
            int size = q.size();
            
            boolean flag = true;
            int count1 = 0; //this pointer will count the number of nodes, having only right child null
            int count2 = 0; //this pointer will count the number of nodes, having both childs null
            while(size-- > 0){
                Pair rem = q.remove();
                if(rem.lvl == level - 1){
                    if(rem.node.left == null && rem.node.right == null){
                        count2++;
                    }else if(rem.node.left == null){
                        flag = false;
                        break;
                    }else if(rem.node.right == null){ //if reached here, that means, only left child is there
                        if(count1 == 1 || count2 == 1){
                            flag = false;
                            break;
                        }
                        count1++;
                    }else{ //when both left and right child are there //[1,2,3,5,null,7,8]
                        if(count1 == 1 || count2 == 1){
                            flag = false;
                            break;
                        }
                    }
                }else if(rem.lvl != level){ //any level except 2nd last level
                    if(rem.node.left == null || rem.node.right == null){
                        flag = false;
                        break;
                    }
                }
                
                //add all the child nodes
                if(rem.node.left != null){
                    q.add(new Pair(rem.node.left, rem.lvl + 1));
                }
                
                if(rem.node.right != null){
                    q.add(new Pair(rem.node.right, rem.lvl + 1));
                }
            }
            
            if(flag == false){
                return false;
            }
        }
        
        return true;
    }
    
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        
        return Math.max(lh, rh) + 1;
    }
}

//TC : O(n)
//SC : O(n)
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        boolean stop = false;
        Queue<TreeNode> q = new LinkedList<>(); //as it support the null
        q.add(root);
        
        while(q.size() > 0){
            TreeNode rem = q.remove();
            if(rem == null){
                stop = true;
            }else{
                if(stop == true) return false;
                q.add(rem.left);
                q.add(rem.right);
            }
        }
        
        return true;
    }
}
