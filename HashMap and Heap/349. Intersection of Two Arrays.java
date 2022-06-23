//TC : O(Max(nums1.length, nums2.length)) + O(size of AL);
//just first make the hashmap for the long array, store count of each unique element
//then iterate over the smaller length array and check if its element is there in the hasmap, if it is, then
//store it in the result and remove its entry from the hm
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        if(nums2.length <= nums1.length){
            for(int i = 0; i < nums1.length; ++i){
                if(hm.containsKey(nums1[i])){
                    hm.put(nums1[i], hm.get(nums1[i]) + 1);
                }else{
                    hm.put(nums1[i], 1);
                }
            }
        }else{
            for(int i = 0; i < nums2.length; ++i){
                if(hm.containsKey(nums2[i])){
                    hm.put(nums2[i], hm.get(nums2[i]) + 1);
                }else{
                    hm.put(nums2[i], 1);
                }
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        if(nums2.length <= nums1.length){
            for(int i = 0; i < nums2.length; ++i){
                if(hm.containsKey(nums2[i])){
                    ans.add(nums2[i]);
                    hm.remove(nums2[i]);
                }
            }
        }else{
            for(int i = 0; i < nums1.length; ++i){
                if(hm.containsKey(nums1[i])){
                    ans.add(nums1[i]);
                    hm.remove(nums1[i]);
                }
            }
        }
        
        int[] res = new int[ans.size()];
        for(int i = 0;i < ans.size(); ++i){
            res[i] = ans.get(i);
        }
        
        return res;
    }
}
