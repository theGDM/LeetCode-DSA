//Using hm and hs
//TC : O(n) + O(distinct values in the arr)
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0;i < arr.length; ++i){
            int key = arr[i];
            if(hm.containsKey(key)){
                hm.put(key, hm.get(key) + 1); //O(1)
            }else{
                hm.put(key, 1); //O(1)
            }
        }
        
        //Now with the help of hashset we will have only the keys's distinct value
        //and if the size of hm and hs equals, then it means that all the keys have the unique value
        Set<Integer> hs = new HashSet<>(); 
        for(int key : hm.keySet()){ //O(unique value in the arr)
            hs.add(hm.get(key));
        }  
        
        return hs.size() == hm.size();
    }
}
