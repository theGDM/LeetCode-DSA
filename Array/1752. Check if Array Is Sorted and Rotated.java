//TC : O(n)
class Solution {
    public boolean check(int[] nums) {
        // here we compare all the neighbouring elemnts and check whether they are in somewhat sorted
        // there will be a small change due to rotation in the array at only one place.
        // so if there are irregularities more than once, return false
        // else return true;
        int irregularities = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] > nums[(i + 1) % nums.length]){
                irregularities++;
            }
        }
        
        return irregularities > 1 ? false : true;
    }
}
