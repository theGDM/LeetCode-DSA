/*Complete the function below*/
class Solution{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        //first we will get the indegree vertices
        //one thing to note that, the vertex which don't have any incoming edge, will not get added
        //so keep that in mind to add them after
        for(int v = 0; v < V; ++v){
            for(int n : adj.get(v)){
                if(hm.containsKey(n)){
                    hm.put(n, hm.get(n) + 1);
                }else{
                    hm.put(n, 1);
                }
            }
        }
        
        //Now those vertex which don't have any edges pointed to them, will
        //be appointed 0 indegree
        for(int v = 0; v < V; ++v){
            if(hm.containsKey(v) == false){
                hm.put(v, 0);
            }
        }
        
        //check
        // for(int v : hm.keySet()){
        //     System.out.println(v + " " + hm.get(v));
        // }
        
        //put all those vertices which have 0 indegree
        Queue<Integer> q = new ArrayDeque<>();
        for(int v : hm.keySet()){
            if(hm.get(v) == 0){
                q.add(v);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        while(q.size() > 0){
            int remV = q.remove();
            
            res.add(remV);
            
            for(int n : adj.get(remV)){
                hm.put(n, hm.get(n) - 1); //decrese the indgree by 1
                if(hm.get(n) == 0){ //if indegree got 0, add in the queue
                    q.add(n);
                }
            }
        }
        
        //ans array
        int ans[] = new int[res.size()];
        //fill the ans array with the value of res AL
        for(int i = 0; i < res.size(); ++i){
            ans[i] = res.get(i);
        }
        
        return ans;
    }
}
