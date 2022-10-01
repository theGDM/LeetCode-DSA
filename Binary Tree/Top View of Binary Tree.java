//BFS
//TC : O(n)
//SC : O(n), worst case left skewed binary tree or right skewed
class Solution{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    public static class Pair{
        Node node; //data
        int index; //horizontal level
        
        Pair(Node node, int index){
            this.node = node;
            this.index = index;
        }
    }
    
    static ArrayList<Integer> topView(Node root){
        int left = 0;
        int right = 0;
        Queue<Pair> q = new ArrayDeque<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        q.add(new Pair(root, 0));
        while(q.size() > 0){
            int size = q.size();
            
            while(size-- > 0){
                Pair rem = q.remove(); //remove
                
                if(hm.containsKey(rem.index) == false){ //work
                    hm.put(rem.index, rem.node.data);
                }
                
                left = Math.min(left, rem.index); //update for left most inded
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
