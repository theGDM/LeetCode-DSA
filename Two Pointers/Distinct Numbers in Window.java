//TC : O(n)
//SC : O(k) //size of window
public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < B; ++i){
            int key = A.get(i);
            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }
        
        res.add(hm.size()); //result for the first window
        for(int i = B; i < A.size(); ++i){
            int inc = A.get(i); //include
            int exc = A.get(i - B); //exclude
            
            hm.put(inc, hm.getOrDefault(inc, 0) + 1); //include the inc in the hashmap
            if(hm.get(exc) == 1){
                hm.remove(exc);
            }else{
                hm.put(exc, hm.get(exc) - 1);
            }
          
            res.add(hm.size()); //store the window size
        }
        
        return res;
    }
}
