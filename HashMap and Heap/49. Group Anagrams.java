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
