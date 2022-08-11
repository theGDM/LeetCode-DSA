class Solution {
    //permutation is allowed
    //worst case : O(n4)
    //in arr A and B, total pair formed will be N2
    //in arr C and D, total pair formed will be N2
    //at worst case let say, sum of all the pairs int (AB) is 1, so they belongs to same key, same with case
    //pair (CD), all the pairs sum is -1, so there will N4 worst case time complexity
    //pointer, se kaam ni chalega, kyuki there is chance some quadruplets get missed..
    //duplicates pairs are allowed

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<>();
        
        //make hashmap of key - pair(AB)
        for(int i = 0; i < nums1.length; ++i){
            for(int j = 0; j < nums2.length; ++j){
                int sum = nums1[i] + nums2[j];
                
                if(map.containsKey(sum) == false){
                    map.put(sum, new ArrayList<>());
                }
                map.get(sum).add(new ArrayList(Arrays.asList(nums1[i], nums2[j])));
            }
        }
        
        // System.out.println(map);
        
        int count = 0;
        for(int i = 0; i < nums3.length; ++i){
            for(int j = 0; j < nums4.length; ++j){
                int sum = nums3[i] + nums4[j];
                int remTar = 0 - sum;
                if(map.containsKey(remTar)){
                    count += map.get(remTar).size();
                }
            }
        }
        return count;
    }
}
