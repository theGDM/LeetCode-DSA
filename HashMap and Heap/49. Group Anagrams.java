//Hashmap between frequency map, and the arraylist of strings
//strings having the same fmap, will belong to the one set only..
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> bmap = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String str : strs){
            HashMap<Character, Integer> fmap = new HashMap<>();
            
            //creating the frequency map
            for(char ch : str.toCharArray()){
                fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
            }
            
            if(bmap.containsKey(fmap) == false){
                ArrayList<String> list = new ArrayList<>();
                list.add(str); 
                bmap.put(fmap, list);
            }else{
                ArrayList<String> list = bmap.get(fmap);
                list.add(str);
            }
        }
        
        for(ArrayList<String> val : bmap.values()){
            res.add(val);
        }
        
        return res;
    }
}


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
        for(String str : strs){
            HashMap<Character, Integer> freq = new HashMap<>(); //create frequency map for each str
            for(int i  = 0; i < str.length(); ++i){
                char ch = str.charAt(i);
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            }
            
            if(map.containsKey(freq) == false){
                map.put(freq, new ArrayList<>());
            }
            map.get(freq).add(str);
        }
        
        List<List<String>> res = new ArrayList<>();
        for(HashMap<Character, Integer> freq : map.keySet()){
            res.add(map.get(freq));
        }
        
        return res;
    }
}
