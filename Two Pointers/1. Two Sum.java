//Two traversals, O(n) algorithm
//SC : O(n) as all the elements index are stored
class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>(); //idx arrayList
        //make arrayList of index
        for(int i = 0; i < nums.length; ++i){
            int num = nums[i];
            if(hm.containsKey(num) == false){
                hm.put(num, new ArrayList<>());
            }
            
            hm.get(num).add(i);
        }
        
        for(int i = 0;i < nums.length; ++i){
            int num = nums[i];
            int remTarget = target - num;
            //if hm contains, remTarget, but make sure it is not half of num, then go in this loop
            if(hm.containsKey(remTarget) == true && remTarget != num){
                return new int[]{i, hm.get(remTarget).get(0)};
            }else if(remTarget == num && hm.get(remTarget).size() >= 2){ //if it half of num, then check size of hm.get(remTarget)
                return new int[]{hm.get(remTarget).get(0), hm.get(remTarget).get(1)};
            }
        }
        
        return new int[]{-1, -1};
    }
}

//One Traversals, O(n) algorithm
//SC : O(n);
//In this algo, we will store the, index of visited element, if it s complement is not found, and if its 
//found, it will always be in left of index i..
class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>(); //idx 
        for(int i = 0; i < nums.length; ++i){
            if(hm.containsKey(target - nums[i])){
                return new int[]{hm.get(target - nums[i]), i};
            }else{
                hm.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
