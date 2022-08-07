//TC : O(n) Two traversals
//SC : O(n)
class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        
        for(int num : arr){
            hs.add(num); //add unique elements
            hm.put(num, hm.getOrDefault(num, 0) + 1); //make frequency map
        }
        
        // System.out.println(hm);
        int count = 0;
        for(int num : hs){ //Unique values get through hashset
            int comp = k - num;
            if(comp == num){ //if complement is equal to num, then compute via formula
                count += hm.get(num) * (hm.get(num) - 1) / 2;
            }else if(hm.containsKey(comp) && num < comp){ //calculate only one time (ex : 2, 3 , Tar = 5)
                count += hm.get(num) * hm.get(comp);
            }
            
        }
        return count;
    }
}

//One traversals O(n)
class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for(int num : arr){
            int comp = k - num;
            if(hm.containsKey(comp) == true){
                count += hm.get(comp);
            }
            
            hm.put(num, hm.getOrDefault(num, 0) + 1); //make frequency map
        }
        return count;
    }
}

