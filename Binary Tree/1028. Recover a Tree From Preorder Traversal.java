/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//TC : O(N), where N is length of str
class Solution {
    int i = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        return createBT(traversal, 0);
    }
    
    public TreeNode createBT(String str, int depth){
        int countDash = 0;
        int j = i;
        while(j < str.length() && str.charAt(j) == '-'){ //couting the depth of node
            countDash++;
            j++;
        }
        
        if(countDash != depth){ 
            return null;
        }
        
        int start = j;
        while(j < str.length() && str.charAt(j) != '-'){ //calculating value
            j++;
        }
        
        int val = Integer.parseInt(str.substring(start, j)); //get the value
        i = j; // finally update i
        
        TreeNode node = new TreeNode(val); //make the treenode with found value
        node.left = createBT(str, depth + 1); //call for left child
        //if no left child, then no need for calling right child, matlab yadi left child nahi hai to right child 
        //bhi nahi hoga
        if(node.left != null){
            node.right = createBT(str, depth + 1); //call for right child
        }
        
        return node;
    }
}


//Wrong Logic
//TC : O(N), where N is length of str
class Solution {
    int i = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        if(traversal.length() == 0) return null;
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        while(i < traversal.length()){
            int countDashes = 0;
            while(i < traversal.length() && traversal.charAt(i) == '-'){
                countDashes++;
                i++;
            }
            
            int start = i;
            while(i < traversal.length() && traversal.charAt(i) != '-'){ //calculating value
                i++;
            }
            
            int val = Integer.parseInt(traversal.substring(start, i)); //get the value
            if(map.containsKey(countDashes) == false){
                map.put(countDashes, new ArrayList<>());
            }
            map.get(countDashes).add(val);
        }
        
        
        return createBT(traversal, map);
    }
    
    public TreeNode createBT(String s, HashMap<Integer, ArrayList<Integer>> map){
        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(map.get(0).get(0));
        q.add(root);
        
        int depth = 1;
        while(q.size() > 0){
            int size = q.size();
            ArrayList<Integer> childs = null;
            if(map.containsKey(depth) == true){
                childs = map.get(depth);
            }else{
                break;
            }
            
            int i = 0;
            while(size-- > 0){
                TreeNode rem = q.remove();
                
                rem.left = i < childs.size() ? new TreeNode(childs.get(i)) : null;
                if(rem.left != null){
                    q.add(rem.left);
                }
                i++;
                
                rem.right = i < childs.size() ? new TreeNode(childs.get(i)) : null;
                if(rem.right != null){
                    q.add(rem.right);
                }
                i++;
            }
            
            depth++;
        }
        
        return root;
    }
}
