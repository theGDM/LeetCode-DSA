//brute force using hasmap o(n)
class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0;i < edges.length; ++i){
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            
            //for v1
            if(hm.containsKey(v1)){
                hm.put(v1, hm.get(v1) + 1);
            }else{
                hm.put(v1, 1);
            }
            
            //for v2
            if(hm.containsKey(v2)){
                hm.put(v2, hm.get(v2) + 1);
            }else{
                hm.put(v2, 1);
            }
        }
        
        int center = 0;
        int max = Integer.MIN_VALUE;
        for(int v : hm.keySet()){
            if(hm.get(v) > max){
                max = hm.get(v);
                center = v;
            }
        }
        
        return center;
    }
}

//o(1) //the main idea is that the center vertex will be there in all the edges so 
//we do the compariosn between 1st edge and 2nd edge, the vertex which is common in 
//the both edges will be the center
class Solution {
    public int findCenter(int[][] edges) {
        if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]){
            return edges[0][0];
        }else{
            return edges[0][1];
        }
    }
}

//using freq array o(n - 1) + o(n + 1)
class Solution {
    public int findCenter(int[][] edges) {
        //given n nodes and exactly n - 1 edges
        //edges.length + 1 will give us the total vertices
        int n = edges.length + 1;
        int[] freq = new int[n + 1];
        for(int i = 0;i < edges.length; ++i){
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            
            freq[v1]++;
            freq[v2]++;
        }
          
        int center = 1;
        for(int i = 0; i < n + 1; ++i){
            if(freq[i] > 1){
                center = i;
                break;
            }
        }
        
        return center;
    }
}

//optimized
