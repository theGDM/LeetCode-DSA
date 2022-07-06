class Solution {
    int[] parent;
    int[] dsu;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        
        Arrays.fill(parent, -1); //intially -1 is parent of each node
        int[] e1 = null;
        int[] e2 = null;
        boolean twopf = false;
        
        //first we check if any node, have two parents or not
        for(int i = 0; i < edges.length; ++i){
            int from = edges[i][0];
            int to = edges[i][1];
            
            if(parent[to] == -1){
                parent[to] = from;
            }else{
                e2 = edges[i];
                e1 = new int[]{parent[to], to};
                twopf = true;
                break;
            }
        }
        
        dsu = new int[edges.length + 1];
        for(int i = 0; i <= edges.length; ++i){
            dsu[i] = i;
        }
        
        if(twopf == false){
            //no vertex have the two parents, so edge creating the cycle will be the res;
            int[] res = null;
            for(int i = 0; i < edges.length; ++i){
                int from = edges[i][0];
                int to = edges[i][1];
                
                int fromLead = find(from);
                if(fromLead == to){
                    res = edges[i];
                    break;
                }else{
                    dsu[to] = fromLead;
                }
            }
            
            return res;
        }else{
            //check for cycle
            boolean noCycleFlag = false;
            for(int i = 0; i < edges.length; ++i){
                if(edges[i] == e2){
                    continue;
                }
                
                int from = edges[i][0];
                int to = edges[i][1];
                
                int fromLead = find(from);
                if(fromLead == to){
                    //cycle detected
                    noCycleFlag = true;
                    break;
                }else{
                    dsu[to] = fromLead;
                }
            }
            
            if(noCycleFlag == false){
                return e2;
            }else{
                return e1;
            }
        }
    }
    
    public int find(int x){
        if(dsu[x] == x){
            return x;
        }else{
            dsu[x] = find(dsu[x]);
            return dsu[x];
        }
    }
}
