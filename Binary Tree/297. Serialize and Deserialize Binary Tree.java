/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Wrong Code, for input like [10, 20, 30, 40 , null, 50, 60], String : 10 20 40 . . . 30 50 . . 40 . . 
public class Codec {
    public class Pair{
        TreeNode node;
        int status;
        
        Pair(TreeNode node, int status){
            this.node = node;
            this.status = status;
        }
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    public void buildString(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(".");
            sb.append(" ");
            return;
        }
        
        //add in preorder, with a space
        sb.append(root.val);
        sb.append(" ");
        
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        
        String[] arr = data.split(" ");
        return buildTree(arr);
    }
    
    public TreeNode buildTree(String[] arr){
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Stack<Pair> stk = new Stack<>();
        
        stk.push(new Pair(root, 0));
        int i = 1;
        
        while(i < arr.length){
            Pair top = stk.peek();
            if(arr[i].equals(".")){
                top.status++;
                i++;
            }else if(top.status == 0){
                int val = Integer.parseInt(arr[i]);
                TreeNode left = new TreeNode(val);
                top.node.left = left;
                stk.push(new Pair(left, 0));
        
                top.status++; //update the status of top
                i++;
            }else if(top.status == 1){
                int val = Integer.parseInt(arr[i]);
                TreeNode right = new TreeNode(val);
                top.node.right = right;
                stk.push(new Pair(right, 0));

                top.status++; //update the status of top
                i++;
            }else{
                stk.pop();
            }
        }
        return root;
    }
}

//write code
public class Codec {
    public class Pair{
        TreeNode node;
        int status;
        
        Pair(TreeNode node, int status){
            this.node = node;
            this.status = status;
        }
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    public void buildString(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(".");
            sb.append(" ");
            return;
        }
        
        //add in preorder, with a space
        sb.append(root.val);
        sb.append(" ");
        
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        
        String[] arr = data.split(" ");
        return buildTree(arr);
    }
    
    //building tree from preorder
    public TreeNode buildTree(String[] arr){
        TreeNode root = new TreeNode(Integer.parseInt(arr[0])); //creating the root node
        Stack<Pair> stk = new Stack<>();
        
        stk.push(new Pair(root, 0)); //pusing the root pair
        int i = 1;
        
        while(i < arr.length){
            Pair top = stk.peek();
            if(top.status == 0){                
                if(arr[i].equals(".") == false){
                    int val = Integer.parseInt(arr[i]);
                    TreeNode left = new TreeNode(val);
                    top.node.left = left;
                    stk.push(new Pair(left, 0));
                }
        
                top.status++; //update the status of top
                i++;
            }else if(top.status == 1){
                if(arr[i].equals(".") == false){
                    int val = Integer.parseInt(arr[i]);
                    TreeNode right = new TreeNode(val);
                    top.node.right = right;
                    stk.push(new Pair(right, 0));
                }

                top.status++; //update the status of top
                i++;
            }else{
                stk.pop();
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
