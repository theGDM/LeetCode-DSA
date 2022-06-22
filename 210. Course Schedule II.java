class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //make graph
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        
        //fill each vertex with the empty arrayList
        for(int v = 0; v < numCourses; ++v){
            graph[v] = new ArrayList<>();
        }
        
        //make the adjacency list
        for(int i = 0;i < prerequisites.length; ++i){
            int ai = prerequisites[i][0];
            int bi = prerequisites[i][1];
            
            graph[ai].add(bi);
        }
        
        int[] res = kahnsAlgo(numCourses, graph); //kahns's algo
        reverse(res); //reverse the result //as topological sort
        return res;
    }
    
    public void reverse(int[] a){
        int l = 0, r = a.length - 1;
        
        while(l < r){
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
            ++l;
            --r;
        }
    }
    
    public int[] kahnsAlgo(int V, ArrayList<Integer>[] graph){
        //count the indegree of each vertices
        int[] inDegree = new int[V];
        for(int v = 0; v < V; ++v){
            for(int n : graph[v]){
                inDegree[n]++; //increase the indegree of vertex where edge is directed;
            }
        }
        
        //fill the queue whose indegree is 0, that means no one depends on it
        Queue<Integer> q = new ArrayDeque<>();
        for(int v = 0; v < V; ++v){
            if(inDegree[v] == 0){
                q.add(v);
            }
        }
        
        int idx = 0;
        int[] res = new int[V];
        
        while(q.size() > 0){
            int rv = q.remove();
            
            res[idx] = rv;
            ++idx;
            
            for(int n : graph[rv]){
                inDegree[n]--; //decrese its indegree by 1
                if(inDegree[n] == 0){
                    q.add(n);
                }
            }
        }
        
        if(idx == V) return res; 
        else return new int[]{}; //means we got a cycle
    }
}
