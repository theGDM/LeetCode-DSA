//Vertical Order - I
//If 2 nodes lie in the same vertical level, they should be printed in the order they appear in the level order traversal of the tree.
class Solution{
    //Function to find the vertical order traversal of Binary Tree.
    public static class Pair{
        Node node;
        int hl;
        int vl;
        
        Pair(Node node, int hl, int vl){
            this.node = node;
            this.hl = hl;
            this.vl = vl;
        }
    }
    
    public static ArrayList<Integer> verticalOrder(Node root) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0, 0));

        int minl = 0;
        int maxr = 0;
        
        ArrayList<Integer> res = new ArrayList<>();
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
                Pair rem = q.remove(); //remove
                
                minl = Math.min(minl, rem.vl); //work1
                maxr = Math.max(maxr, rem.vl);
                
                if(hm.containsKey(rem.vl) == false){ //work2
                    hm.put(rem.vl, new ArrayList<>());
                }
                hm.get(rem.vl).add(rem.node.data);
                
                if(rem.node.left != null){ //add left child of remove node
                    q.add(new Pair(rem.node.left, rem.hl + 1, rem.vl - 1)) ;
                }
                
                if(rem.node.right != null){ //add right child of remove node
                    q.add(new Pair(rem.node.right, rem.hl + 1, rem.vl + 1));
                }
            }   
        }
        
        for(int i = minl; i <= maxr; ++i){
            ArrayList<Integer> part = hm.get(i);
            for(int n : part){
                res.add(n);
            }
        }
        
        return res;
    }
    
}
