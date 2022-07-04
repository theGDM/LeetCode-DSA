class Solution {
    int[] rank;
    int[] parent;
    public int numSimilarGroups(String[] strs) {
        int v = strs.length;
        rank = new int[v];
        parent = new int[v];
        
        for(int i = 0; i < v; ++i){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(int i = 0; i < strs.length - 1; ++i){
            for(int j = i + 1; j < strs.length; ++j){
                String str1 = strs[i];
                String str2 = strs[j];
                
                if(isSimilar(str1, str2)){
                    unionHelper(i, j);
                }
            }
        }
        
        int count = 0;
        for(int i = 0; i < v; ++i){
            if(parent[i] == i){
                ++count;
            }
        }
        
        return count;
    }
    
    public boolean isSimilar(String s1, String s2){
        int c = 0;
        for(int i = 0; i < s1.length(); ++i){
            if(s1.charAt(i) != s2.charAt(i)){
                ++c;  
            }
        }
        
        if(c == 0 || c == 2){
            return true;
        }else{
            return false;
        }
    }
    
    public int find(int x){
        if(parent[x] == x){
            return x;
        }else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    public void unionHelper(int x, int y){
        int xl = find(x);
        int yl = find(y);
        
        if(xl != yl){
            if(rank[xl] < rank[yl]){
                parent[xl] = yl;
            }else if(rank[yl] < rank[xl]){
                parent[yl] = xl;
            }else{
                parent[xl] = yl;
                rank[yl]++;
            }
        }
    }
}
