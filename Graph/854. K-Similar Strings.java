class Solution {
    public int kSimilarity(String s1, String s2) {
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        q.add(s1);
        int level = 0;
        
        while(q.size() > 0){
            int size = q.size();
            
            while(size-- > 0){
                String rem = q.remove(); //remove
                
                if(visited.contains(rem) == true){
                    continue;
                }
                
                visited.add(rem); //mark*
                
                if(rem.equals(s2)){ //work
                    return level;
                }
                
                for(String str : getNeighbours(rem, s2)){
                    if(visited.contains(str) == false){
                        q.add(str);
                    }
                }
            }
            ++level;
        }
        return -1;
    }
    
    public ArrayList<String> getNeighbours(String str, String s2){
        ArrayList<String> res = new ArrayList<>();
        int idx = -1;
        
        for(int i = 0; i < str.length(); ++i){
            if(str.charAt(i) != s2.charAt(i)){
                idx = i;
                break;
            }
        }
        
        if(idx != -1){
            for(int j = idx + 1; j < str.length(); ++j){
                if(str.charAt(j) == s2.charAt(idx)){
                    String newStr = swap(str, idx, j);
                    res.add(newStr);
                }
            }
        }
        
        return res;
    }
    
    public String swap(String str, int i, int j){
        StringBuilder sb = new StringBuilder(str);
        
        char chi = str.charAt(i);
        char chj = str.charAt(j);
        
        sb.setCharAt(i, chj);
        sb.setCharAt(j, chi);
        
        return sb.toString();
    }
}
