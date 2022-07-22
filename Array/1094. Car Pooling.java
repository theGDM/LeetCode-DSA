//HashMap version
// [[2, 2, 6], [2, 4, 7], [8, 6, 7]]
// 11
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> stops = new ArrayList<>();
        
        for(int[] trip : trips){
            int cap = trip[0];
            int from = trip[1];
            int to = trip[2];
            
            if(map.containsKey(from) == false){
                map.put(from, +cap);
                stops.add(from);
            }else{
                map.put(from, map.get(from) + cap);
            }
            
            if(map.containsKey(to) == false){
                map.put(to, -cap);
                stops.add(to);
            }else{
                map.put(to, map.get(to) - cap);
            }
        }
        
        System.out.println(stops);
        Collections.sort(stops);
        
        int pic = 0;
        for(int stop : stops){
            int delta = map.get(stop);
            
            pic += delta;
            
            if(pic > capacity){
                return false;
            }
        }
        
        return true;
    }
}

//Array and TreeSet Version
//since, stops can have value between, 0 <= fromi < toi <= 1000
// [[2, 2, 6], [2, 4, 7], [8, 6, 7]]
// 11
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] map = new int[1001];
        TreeSet<Integer> stops = new TreeSet<>(); //it gives element in increasing order, and do
                                                  //not contains duplicate entry
        for(int[] trip : trips){
            int cap = trip[0];
            int from = trip[1];
            int to = trip[2];
            
            map[from] += cap;
            stops.add(from);
            
            map[to] -= cap;
            stops.add(to);
        }
        
        int pic = 0;
        for(int stop : stops){
            int delta = map[stop];
            
            pic += delta;
            
            if(pic > capacity){
                return false;
            }
        }
        
        return true;
    }
}

