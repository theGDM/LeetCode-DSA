
//we can use treemap, but, adding and removing from treemap is logn operation
class Solution{
    //Function to return a list containing the bottom view of the given tree.
    public static class Pair{
        Node node; //data
        int index; //horizontal level
        
        Pair(Node node, int index){
            this.node = node;
            this.index = index;
        }
    }
    
    public ArrayList <Integer> bottomView(Node root){
        int left = 0;
        int right = 0;
        Queue<Pair> q = new ArrayDeque<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        q.add(new Pair(root, 0));
        while(q.size() > 0){
            int size = q.size();
            
            while(size-- > 0){
                Pair rem = q.remove(); //remove
                
                hm.put(rem.index, rem.node.data); //keep updating it, as we need last element of every
                                                  //horizontal index
                left = Math.min(left, rem.index); //update for left most index
                right = Math.max(right, rem.index); //update for right most index
                
                if(rem.node.left != null){
                    q.add(new Pair(rem.node.left, rem.index - 1)); //as we adding left child, its horizontal
                }                                                  //index will be decreases
                
                if(rem.node.right != null){
                    q.add(new Pair(rem.node.right, rem.index + 1));
                }
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = left; i <= right; ++i){
            ans.add(hm.get(i));
        }
        
        return ans;
    }
}
