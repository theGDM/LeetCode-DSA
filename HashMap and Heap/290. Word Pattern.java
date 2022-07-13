//Using Single HashMap
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length){
            return false;
        }
        
        HashMap<Character, String> hm = new HashMap<>();
        
        for(int i = 0; i < arr.length; ++i){
            char ch = pattern.charAt(i);
            if(hm.containsKey(ch)){
                if(hm.get(ch).equals(arr[i]) == false){
                    return false;
                }
            }else{
                if(hm.containsValue(arr[i])){ //this string is already visited by some char
                    return false;
                }
                hm.put(ch, arr[i]);
            }
        }
        
        return true;
    }
}

//using one hashmap, and one hashset
//O(n) Solution
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length){
            return false;
        }
        
        HashMap<Character, String> hm = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < arr.length; ++i){
            char ch = pattern.charAt(i);
            if(hm.containsKey(ch)){
                if(hm.get(ch).equals(arr[i]) == false){
                    return false;
                }
            }else{
                if(set.contains(arr[i])){ //this string is already visited by some char
                    return false;
                }
                
                hm.put(ch, arr[i]); //put in HashMap
                set.add(arr[i]); //put in HashSet
            }
        }
        
        return true;
    }
}

