public class Solution {
    /**
     * @param nums: the input array
     * @param target: the target number
     * @return: return the target pair
     *          we will sort your return value in output
     */

    public int getNext(int idx, int[] nums){
        if(idx == nums.length || nums[idx] < 0){
            //Negative -> right to left 
            idx--;
            if(idx == nums.length) return idx;
            while(idx >= 0 && nums[idx] >= 0){
                idx--;
            }
            if(idx >= 0) return idx;
        }

        //positive -> left to right
        if(idx < 0) idx = 0;
        else idx++;

        while(idx < nums.length && nums[idx] < 0){
            idx++;
        }

        return idx;
    } 

    public int getPrev(int idx, int[] nums){
        if(idx == nums.length || nums[idx] >= 0){
            //Positive -> right to left
            idx--;
            if(idx == nums.length) return idx;
            while(idx >= 0 && nums[idx] < 0){
                idx--;
            }
            if(idx >= 0) return idx;
        }

        //negative -> left to right
        if(idx < 0) idx = 0;
        else idx++;

        while(idx < nums.length && nums[idx] >= 0){
            idx++;
        }

        return idx;
    } 
    public List<List<Integer>> twoSumVII(int[] nums, int target) {
        // write your code here
        int left = getNext(nums.length, nums);
        int right = getPrev(nums.length, nums);

        List<List<Integer>> res = new ArrayList<>();
        while(left < nums.length && right < nums.length && nums[left] < nums[right]){
            int sum = nums[left] + nums[right];

            if(sum == target){
                int idx1 = Math.min(left, right);
                int idx2 = Math.max(left, right);

                res.add(new ArrayList(Arrays.asList(idx1 , idx2)));
                left = getNext(left, nums);
                right = getPrev(right, nums);
            }else if(sum < target){
                left = getNext(left, nums);
            }else{
                right = getPrev(right, nums);
            }
        }

        return res;
    }
}
