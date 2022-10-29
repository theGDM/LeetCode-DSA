//TC : O(N)
//SC : O(logN)
class Solution{
    static int NumberOfTurns(Node root, int first, int second){
        List<String> path1 = nodeToRootPath(root, first);
        List<String> path2 = nodeToRootPath(root, second);
        // System.out.println(path1);
        // System.out.println(path2);
        
        int i = path1.size() - 1;
        int j = path2.size() - 1;
        
        while(i >= 0 && j >= 0 && path1.get(i).equals(path2.get(j)) == true){ //logN
            path1.remove(i);
            path2.remove(j);
            i--;
            j--;
        }
        
        Collections.reverse(path2); //reverse the path2 //TC : O(logN) = O(logN) = O(Height of BT),  because at worst the search element could be the leaf node, so the size of the path list will be logn 
        path1.addAll(path2); //and append all its element to path1 arraylist
        
        // System.out.println(path1);
        int turn = 0;
        String prev = ".";
        
        //ignoring the ".", on both sides
        for(int k = 1; k <= path1.size() - 2; ++k){
            if(k == 1){
                prev = path1.get(k);
            }else{
                String curr = path1.get(k);
                if(curr != prev){
                    turn++;
                }
                prev = curr;
            }
        }
        
        if(turn == 0) return -1;
        return turn;
    }
    
    //getting root to node path O(N)
    public static List<String> nodeToRootPath(Node root, int val){
        if(root == null) return new ArrayList<>();
        if(root.data == val){
            ArrayList<String> base = new ArrayList<>();
            base.add(".");
            return base;
        }
        
        List<String> left = nodeToRootPath(root.left, val);
        if(left.size() > 0){
            left.add("L");
            return left;
        }
        
        List<String> right = nodeToRootPath(root.right, val);
        if(right.size() > 0){
            right.add("R");
            return right;
        }
        
        return new ArrayList<>();
    }
}
