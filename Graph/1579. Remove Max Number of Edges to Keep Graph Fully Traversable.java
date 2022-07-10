//TC :3e.alpha + 3v = in worst case --> e = v^2
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] p = new int[n + 1];
        int[] r = new int[n + 1];
        
        for(int i = 0; i < n; ++i){
            p[i] = i;
            r[i] = 0;
        }
        
        int removeEdge = 0;
        int e1 = 0;
        int e2 = 0;
        
        //first we will cover the edges which can be used by both alice and bob
        for(int[] edge : edges){
            if(edge[0] == 3){
                int u = edge[1];
                int v = edge[2];
                
                boolean didUnionHappend = unionHelper(p, r, u, v);
                if(didUnionHappend == false){
                    removeEdge++;
                }else{
                    e1++;
                    e2++;
                }
            }
        }
        
        //Now exlplore those edges which alice only can take, if some edge that can take alice to the vertices,
        //which he can visit using the type 3 edge than, its unnecessary edge
        int[] p1 = p.clone();
        int[] r1 = r.clone();
        for(int[] edge : edges){
            if(edge[0] == 1){
                int u = edge[1];
                int v = edge[2];
                
                boolean didUnionHappend = unionHelper(p1, r1, u, v);
                if(didUnionHappend == false){
                    removeEdge++;
                }else{
                    e1++;
                }
            }
        }
        
        //Now exlplore those edges which bob only can take, if some edge that can take bob to the vertices,
        //which he can visit using the type 3 edge than, its unnecessary edge
        int[] p2 = p.clone();
        int[] r2 = r.clone();
        for(int[] edge : edges){
            if(edge[0] == 2){
                int u = edge[1];
                int v = edge[2];
                
                boolean didUnionHappend = unionHelper(p2, r2, u, v);
                if(didUnionHappend == false){
                    removeEdge++;
                }else{
                    e2++;
                }
            }
        }
        
        if(e1 != n - 1 || e2 != n - 1){
            return -1;
        }else{
            return removeEdge;
        }
        
    }
    
    public int find(int[] p, int x){
        if(p[x] == x){
            return x;
        }else{
            int pox = p[x]; //parent of x
            int setLead = find(p, pox); //find its setlead
            p[x] = setLead; //path Compression
            return setLead; //return the setlead
        }
    }
    
    public boolean unionHelper(int[] p, int[] r, int u, int v){
        int U = find(p, u);
        int V = find(p, v);
        
        if(U == V){
            return false;
        }
        
        if(r[U] < r[V]){
            p[U] = V;
        }else if(r[V] < r[U]){
            p[V] = U;
        }else{
            p[U] = V;
            r[V]++;
        }
        
        return true;
    }
}
