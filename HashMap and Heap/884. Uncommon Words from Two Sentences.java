//TC : O(n)
//Iss question me jo dono string me unique ocuur ho raha hai, usko al me add karke dena.
//means count of that will always be 1
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> hm = new HashMap<>();
        //split s1 around whitespace, and make its hashmap
        for(String word : s1.split("\\s")){
            if(hm.containsKey(word)){
                hm.put(word, hm.get(word) + 1);
            }else{
                hm.put(word, 1); 
            }
        }
        
        for(String word : s2.split("\\s")){
            if(hm.containsKey(word)){
                hm.put(word, hm.get(word) + 1);
            }else{
                hm.put(word, 1); 
            }
        }
        
        ArrayList<String> res = new ArrayList<>();
        for(String word : hm.keySet()){
            if(hm.get(word) == 1){
                res.add(word);
            }
        }
        
        String[] s = new String[res.size()];
        
        for(int i = 0; i < res.size(); ++i){
            s[i] = res.get(i);
        }
        
        return s;
    }
}
