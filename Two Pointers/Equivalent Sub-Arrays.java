//TC : O(n) 
class Solution{ 
    // Method to calculate distinct sub-array 
    static int countDistinctSubarray(int arr[], int n) { 
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; ++i){
            set.add(arr[i]);
        }
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        int k = set.size();
        int ans = 0;
        
        int i = -1;
        int j = -1;
        
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            
            while(i < arr.length - 1){ //acquire till, size becomes k
                f1 = true;
                
                i++;
                hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
                
                if(hm.size() == k){
                    ans += arr.length - i;
                    break;
                }
            }
            
            if(i == arr.length && hm.size() != k) break; //little optimisation, no need to relase jus break from it
            
            while(j < i){ //release
                f2 = true;
                
                j++;
                if(hm.get(arr[j]) == 1){
                    hm.remove(arr[j]);
                }else{
                    hm.put(arr[j], hm.get(arr[j]) - 1);
                }
                
                if(hm.size() == k){
                    ans += arr.length - i; 
                }else{
                    break;
                }
            }
            
            if(f1 == false && f2 == false){
                break;
            }
        }
        
        return ans;
    }
}
