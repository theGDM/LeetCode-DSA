// Time Complexity: O(N), where NN is the length of cpdomains, and assuming the length of cpdomains[i] is fixed.
//Space Complexity: O(N), the space used in our count.
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String str : cpdomains){
            String[] arr = str.split(" "); //first split on the basis of 
            
            int count = Integer.parseInt(arr[0]);
            String[] domains = arr[1].split("\\.");//important point, use double backward slash

            String s = "";
            for(int i = domains.length - 1; i >= 0; --i){
                if(i == domains.length - 1){
                    s = domains[i] + s;
                }else{
                    s = domains[i] + "." + s;
                }
                
                if(hm.containsKey(s) == true){
                    hm.put(s, hm.get(s) + count);
                }else{
                    hm.put(s, count);
                }
            }
        }
        
        List<String> res = new ArrayList<>();
        
        for(String key : hm.keySet()){
            res.add(hm.get(key) + " " + key);
        }
        
        return res;
    }
}
