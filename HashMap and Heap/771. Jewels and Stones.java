//TC : O(stones.length)
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < stones.length(); ++i){ //total stones i have
            char s = stones.charAt(i);
            
            if(hm.containsKey(s)){
                hm.put(s, hm.get(s) + 1);
            }else{
                hm.put(s, 1);
            }
        }
        
        int count = 0;
        for(int i = 0; i < jewels.length(); ++i){ 
            char s = jewels.charAt(i); //type of stones that are jewels
            
            if(hm.containsKey(s)){ //checking how many that jewel stone i have
                count += hm.get(s);
            }
        }
        
        return count;
    }
}
