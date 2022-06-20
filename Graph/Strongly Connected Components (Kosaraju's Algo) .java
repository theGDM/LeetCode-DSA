//User function Template for Java

//sabse sab component reachable hone chahiye
//connected componet -> undireceted graph
//strongly connected component ->directed graph, har vertex se har vertex tak ka rasta
//steps
//1. dfs from all vertices(all vertices as root)
//2. add to stack in postorder
//3. transpose all the edges
//4. stack se pop, aur use popped edges se transpose graph ke ander dfs lagao
//jitni baar dfs laga utne strongly connected component
class Solution{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis1 = new boolean[adj.size()];
        //step 1 (fill stack)
        Stack<Integer> stk = new Stack<>();
        for(int v = 0; v < adj.size(); ++v){
            if(vis1[v] == false){
               dfs1(v, adj, vis1, stk); 
            }
        }
        
        //step 2 (transpose of graph)
        ArrayList<ArrayList<Integer>> tsp = new ArrayList<>();
        for(int v = 0; v < adj.size(); ++v){
            tsp.add(new ArrayList<>());
        }
        
        for(int v = 0; v < adj.size(); ++v){
            for(int n : adj.get(v)){
                tsp.get(n).add(v);
            }
        }
        
        //step 3
        int count = 0;
        boolean[] vis2 = new boolean[adj.size()];
        while(stk.size() > 0){
            int v = stk.pop();
            if(vis2[v] == false){
                ++count;
                dfs2(v, tsp, vis2);
            }
        }
        return count;
    }
    
    public void dfs2(int v, ArrayList<ArrayList<Integer>> tsp, boolean[] vis2){
        vis2[v] = true;
        for(int n : tsp.get(v)){
            if(vis2[n] == false){
                dfs2(n, tsp, vis2);
            }
        }
    }
    
    public void dfs1(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis1, Stack<Integer> stk){
        vis1[v] = true;
        for(int n : adj.get(v)){
            if(vis1[n] == false){
                dfs1(n, adj, vis1, stk);
            }
        }
        stk.add(v); //postorder me add
    }
}
