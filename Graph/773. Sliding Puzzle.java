//least number of moves -> BFS
class Solution {
    public class Pair{
        String config;
        int level;
    }
    
    public int slidingPuzzle(int[][] board) {
        HashSet<String> visited = new HashSet<>();
        int[][] direction = {
            {1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}
        };
        
        Queue<Pair> q = new ArrayDeque<>();
        Pair rootPair = new Pair();
        rootPair.config = getConfig(board);
        rootPair.level = 0;
        q.add(rootPair);
        
        while(q.size() > 0){
            Pair rem = q.remove(); //remove
            if(visited.contains(rem.config) == true){
                continue;
            }
            
            visited.add(rem.config); //mark visit
            
            if(rem.config.equals("123450")){ //work
                return rem.level;
            }
            
            int idx = rem.config.indexOf('0');
            
            for(int i : direction[idx]){
                String newConfig = swap(rem.config, idx, i);
                if(visited.contains(newConfig) == false){
                    Pair np = new Pair();
                    np.config = newConfig;
                    np.level = rem.level + 1;
                    q.add(np);
                }
            }
        }
        
        return -1;
    }
    
    public String swap(String str, int i, int j){
        StringBuilder sb = new StringBuilder(str);
        
        char chi = sb.charAt(i);
        char chj = sb.charAt(j);
        sb.setCharAt(i, chj);
        sb.setCharAt(j, chi);
        
        return sb.toString();
    }
    
    public String getConfig(int[][] board){
        StringBuilder sb = new StringBuilder();
        
        for(int[] row : board){
            for(int val : row){
                sb.append(val);
            }
        }
        
        return sb.toString();
    }
}
