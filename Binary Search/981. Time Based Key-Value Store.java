//HashMap Linear Search
//if M is the number of set function calls, N is the number of get function calls, and L is average length of key and value strings.
//set() -> O(M.1)
//get() -> O(N.timestamp)
class TimeMap {
    HashMap<String, HashMap<Integer, String>> keyTimeMap;
    public TimeMap() {
        keyTimeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) { //O(1)
        // If the 'key' does not exist in map, put new hashmap corresponding to that key
        if(keyTimeMap.containsKey(key) == false){
            keyTimeMap.put(key, new HashMap<>());
        }
        // Store '(timestamp, value)' pair in 'key' bucket of keyTimeMap HashMap.
        keyTimeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) { //O(TimeStamp)
        //if the key does not exist in the keyTimeMap return empty string
        if(keyTimeMap.containsKey(key) == false){
            return "";
        }
        
        HashMap<Integer, String> pairs = keyTimeMap.get(key);
        for(int currTime = timestamp; currTime >= 1; --currTime){
            if(pairs.containsKey(currTime)){
                return pairs.get(currTime);
            }
        }
        
        return "";
    }
}


//TreeMap + Linear Search
//if M is the number of set function calls, N is the number of get function calls, and L is average length of key and value strings.
//hashing the string will take O(L) 
//set() -> O(M.L.log(M)), for M calls
// in this function, in each call we store a value at (key, timestamp) location, which takes O(L⋅logM) time as the internal implementation of sorted maps is some kind of balanced binary tree and in worst case we might have to compare logM nodes (height of tree) of length L each with our key.

//get() -> O(N.(L.logM + logM))
//In the get() function, we will find correct key in our map, which can take O(L⋅logM) time and then use binary search on that bucket which can have at most M elements, which takes O(logM) time.

//map.floorKey(key) -> The method call returns the greatest key less than or equal to key, or null if there is no such key.
class TimeMap {
    HashMap<String, TreeMap<Integer, String>> keyTimeMap;
    public TimeMap() {
        keyTimeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) { //O(1)
        // If the 'key' does not exist in map, put new hashmap corresponding to that key
        if(keyTimeMap.containsKey(key) == false){
            keyTimeMap.put(key, new TreeMap<>());
        }
        // Store '(timestamp, value)' pair in 'key' bucket of keyTimeMap HashMap.
        keyTimeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) { //O(TimeStamp)
        //if the key does not exist in the keyTimeMap return empty string
        if(keyTimeMap.containsKey(key) == false){
            return "";
        }
        
        TreeMap<Integer, String> pairs = keyTimeMap.get(key);
        Integer floorKeyJustLessThanTimeStamp = pairs.floorKey(timestamp);
        
        if(floorKeyJustLessThanTimeStamp != null){
            return pairs.get(floorKeyJustLessThanTimeStamp);
        }
        
        return "";
    }
}


/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
 
 
