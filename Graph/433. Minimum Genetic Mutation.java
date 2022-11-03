//Graph BFS solution
//O(V + E)
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>();
        for(String mutation : bank){
            set.add(mutation);
        }
        
        char[] charStr = {'A', 'C', 'G', 'T'};
        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.add(start);
        
        int steps = 0;
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
                String rem = q.remove(); //rem
                
                if(rem.equals(end)) return steps; //work
            
                for(char c : charStr){
                    for(int i = 0; i < rem.length(); ++i){
                        String mutation = rem.substring(0, i) + c + rem.substring(i + 1);
                        if(visited.contains(mutation) == false && set.contains(mutation) == true){
                            visited.add(mutation); //mark visit
                            q.add(mutation);
                        }
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}
