//TC :  O(t.length)
//SC :  O(s.length) + O(t.length)

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        for(int i = 0; i < s.length(); ++i){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            map1.put(ch1, map1.getOrDefault(ch1, 0) + 1);
            map2.put(ch2, map2.getOrDefault(ch2, 0) + 1);
        }
        
        for(char key : map1.keySet()){
            if(map1.containsKey(key) == false || map2.containsKey(key) == false){
                return false;
            }
            
            if((int)map1.get(key) != (int)map2.get(key)){
                System.out.println(key);
                return false;
            }
        }
        
        return true;
    }
}


//TC :  O(s.length)
//SC :  O(s.length + t.length)

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); ++i){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            map.put(ch1, map.getOrDefault(ch1, 0) + 1);
            map.put(ch2, map.getOrDefault(ch2, 0) - 1);
        }
        
        for(char key : map.keySet()){
            if(map.get(key) != 0) return false;
        }
        
        return true;
    }
}
