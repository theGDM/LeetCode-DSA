//brute force
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
