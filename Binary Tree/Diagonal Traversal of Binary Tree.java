/* Node is defined as
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/
//BFS TC : O(N)
class Tree{
      public class Pair{
        Node node;
        int dl;
        
        Pair(Node node, int dl){
            this.node = node;
            this.dl = dl;
        }
    }
    
    public ArrayList<Integer> diagonal(Node root) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));

        int maxdl = 0;
        
        ArrayList<Integer> res = new ArrayList<>();
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
                Pair rem = q.remove(); //remove
                
                maxdl = Math.max(maxdl, rem.dl);
                
                if(hm.containsKey(rem.dl) == false){ //work2
                    hm.put(rem.dl, new ArrayList<>());
                }
                hm.get(rem.dl).add(rem.node.data);
                
                if(rem.node.left != null){ //add left child of remove node
                    q.add(new Pair(rem.node.left, rem.dl + 1)) ;
                }
                
                if(rem.node.right != null){ //add right child of remove node
                    q.add(new Pair(rem.node.right, rem.dl));
                }
            }   
        }
        
        for(int i = 0; i <= maxdl; ++i){
            ArrayList<Integer> part = hm.get(i);
            for(int n : part){
                res.add(n);
            }
        }
        
        return res;
    }
}


//TC : O(n) //DFS
class Tree{
    HashMap<Integer, ArrayList<Integer>> hm;
    int maxdl;
    public ArrayList<Integer> diagonal(Node root) {
        hm = new HashMap<>();
        maxdl = 0;
        DFS(root, 0);
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i <= maxdl; ++i){
            ArrayList<Integer> part = hm.get(i);
            if(part == null) break; //if root hi null pass kiya ho tab, 0 ke corresponding jo bhi aayega
            for(int n : part){      //bo null hoga, so null pointer exception aa jayega
                res.add(n);
            }
        }
        
        return res;
    }
    
    public void DFS(Node node, int dl){
        if(node == null) return;
        
        maxdl = Math.max(maxdl, dl); //updating for maximum diameter level
        if(hm.containsKey(dl) == false){
            hm.put(dl, new ArrayList<>());
        }
        hm.get(dl).add(node.data);
        
        DFS(node.left, dl + 1); //left child ko call karenge to diagonal level ek se badha denge
        DFS(node.right, dl); //right child ko call karenge to digonal level same hoga
    }
}


//TC : O(n) //Iterative Solution
class Tree{
    public ArrayList<Integer> diagonal(Node root) {
        if(root == null) return new ArrayList<>(); //edge case yadi root hi null ho
        
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        
        while(q.size() > 0){
            Node rem = q.remove();
            while(rem != null){
                res.add(rem.data);//right child AL me add karte raho
                if(rem.left != null){ //yadi left child null nahi hai to, q me daalte jao
                    q.add(rem.left);
                }
                rem = rem.right;
            }
        }
        
        return res;
    }
}
