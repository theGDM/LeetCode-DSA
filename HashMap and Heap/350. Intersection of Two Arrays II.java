//Similar to intersection - 1
//in this we need to update the count of the elements after they put in the result, and we stop adding that 
//element if its count becomes 0
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
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
                if(hm.containsKey(nums2[i]) && hm.get(nums2[i]) >= 1){
                    ans.add(nums2[i]);
                    hm.put(nums2[i], hm.get(nums2[i]) - 1);
                }
            }
        }else{
            for(int i = 0; i < nums1.length; ++i){
                if(hm.containsKey(nums1[i]) && hm.get(nums1[i]) >= 1){
                    ans.add(nums1[i]);
                    hm.put(nums1[i], hm.get(nums1[i]) - 1);
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
