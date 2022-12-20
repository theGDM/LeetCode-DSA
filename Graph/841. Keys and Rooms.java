//TC : O(N + E) where N is the number of rooms, and E is the total number of keys.
//SC : O(N) in additional space complexity, to store stack and visited
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited  = new boolean[rooms.size()];
        visited[0] = true;//room 0 is always opened
        Stack<Integer> stk = new Stack<>();
        stk.push(0); //push room 0 initially
        
        while(stk.size() > 0){
            int room = stk.pop();
            for(int key : rooms.get(room)){ //keys present in that room
                if(visited[key] == false){ //if that room is not visited before, then make it visited
                    visited[key] = true;
                    stk.push(key);
                }
            }
        }
        
        for(boolean isVisited : visited){
            if(isVisited == false) return false;
        }
        
        return true;
    }
}
// [[1],[2],[3],[]]
// [[1,3],[3,0,1],[2],[0]]
// [[1,3],[1,4],[2,3,4,1],[],[4,3,2]]
// [[4],[3],[],[2,5,7],[1],[],[8,9],[],[],[6]]
