//TC : O(N * m) N : Total buses, m = routes[i].length
class Solution {
    public class Pair{
        int bus;
        int btsf;
        Pair(int bus, int btsf){
            this.bus = bus;
            this.btsf = btsf;
        }
    }
    
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }
        
        //Make Hashmap for the, bus stops and the number of buses going from that particular bus stop
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for(int bus = 0; bus < routes.length; ++bus){
            for(int busStop : routes[bus]){
                if(hm.containsKey(busStop) == false){
                    hm.put(busStop, new ArrayList<>());
                }
                hm.get(busStop).add(bus);
            }
        }
        
        //Now add all the busses that can we taken from source bus stop
        Queue<Pair> q = new ArrayDeque<>();
        for(int srcBus : hm.get(source)){
            q.add(new Pair(srcBus, 1));
        }
        
        boolean[] visited = new boolean[routes.length];
        while(q.size() != 0){
            Pair rem = q.remove(); //remove
            if(visited[rem.bus] == true){
                continue;
            }
            
            visited[rem.bus] = true; //mark*
            
            for(int busStop : routes[rem.bus]){ //work
                if(busStop == target){
                    return rem.btsf;
                }
            }
            
            for(int busStop : routes[rem.bus]){
                for(int busFromCurrentBusStop : hm.get(busStop)){
                    if(visited[busFromCurrentBusStop] == false){
                        q.add(new Pair(busFromCurrentBusStop, rem.btsf + 1));
                    }
                }
            }
        }
        
        return -1;
    }
}
