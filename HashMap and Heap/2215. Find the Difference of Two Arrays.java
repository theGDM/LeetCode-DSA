//tc : o(n) //array of bigger length
//sc : o(set1.length + set2.length)
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(); //it will have the unique elements of nums1
        Set<Integer> set2 = new HashSet<>(); //it will have the unique elements of nums2
        
        for(int val : nums1){
            set1.add(val);
        }
        
        for(int val : nums2){
            set2.add(val);
        }
        
        
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        
        for(int val : set1){
            if(set2.contains(val) == false){
                res.get(0).add(val);//add only those value which are not in the set2
            }
        }
        
        for(int val : set2){
            if(set1.contains(val) == false){
                res.get(1).add(val);//add only those value which are not in the set1
            }
        }
        
        return res;
    }
}
