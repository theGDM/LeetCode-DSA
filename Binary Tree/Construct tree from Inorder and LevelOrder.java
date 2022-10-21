//O(N2)
//As we are performing work of O(N), in every node's preorder
//TC : O(N)
class GfG{
    Node buildTree(int inord[], int level[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < level.length; ++i){
            map.put(level[i], i);
        }
        
        Node node = helper(inord, map, 0, inord.length - 1);
        return node;
    }
    
    public Node helper(int[] inord, HashMap<Integer, Integer> map, int lo, int hi){
        if(lo > hi) return null;
        
        int minIdx = lo; //assuming that the lo index of inorder array is a minimum index in level order
        for(int i = lo + 1; i <= hi; ++i){
            if(map.get(inord[i]) < map.get(inord[minIdx])){
                minIdx = i;
            }
        }
        
        Node node = new Node(inord[minIdx]);
        node.left = helper(inord, map, lo, minIdx - 1);
        node.right = helper(inord, map, minIdx + 1, hi);
        return node;
    }
}


