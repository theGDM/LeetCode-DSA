//Using brute force approach
//as we know, numbers are from 1 to n
//TC : O(N2);
//SC : O(1);
class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicate = -1, missing = -1;
        for(int i = 1; i <= nums.length; ++i){
            int count = 0;
            for(int j = 0; j < nums.length; ++j){
                if(nums[j] == i){
                    count++;
                }
            }
            
            if(count == 2){ //if we got count = 2, that means that is repeated twice, so it is duplicate element
                duplicate = i;
            }else if(count == 0){//if we don't find that element in nums, that means that is missing
                missing = i;
            }
            
            if(duplicate > 0 && missing > 0){
                break;
            }
        }
        return new int[]{duplicate, missing};
    }
}

//Using Map
//as we know, numbers are from 1 to n
//TC : O(N);
//SC : O(N);
class Solution {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int duplicate = -1, missing = -1;
        for(int n : nums){ //O(N)
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        for(int i = 1; i <= nums.length; ++i){ //O(N)
            if(map.containsKey(i)){
                if(map.get(i) == 2){
                    duplicate = i;
                }
            }else{
                missing = i;
            }
        }
        return new int[]{duplicate, missing};
    }
}

//Using Array
//as we know, numbers are from 1 to n
//TC : O(N);
//SC : O(N);
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[nums.length + 1];
        int duplicate = -1, missing = -1;
        for(int n : nums){ //O(N)
            int idx = n;
            arr[idx]++;
        }
        
        for(int i = 1; i < arr.length; ++i){ //O(N)
            if(arr[i] == 2){
                duplicate = i;
            }else if(arr[i] == 0){
                missing = i;
            }
        }
        return new int[]{duplicate, missing};
    }
}

//Using Sorting
//as we know, numbers are from 1 to n
//TC : O(NlogN);
//SC : O(1);
// This way, the numbers which are equal will always lie together. Further, we can easily identify the missing number by checking if every two consecutive elements in the sorted numsnums array are just one count apart or not.

class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int dup = -1, missing = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1])
                dup = nums[i];
            else if(nums[i] > nums[i - 1] + 1)
                missing = nums[i - 1] + 1;
        }
        
        return new int[] {dup, nums[nums.length - 1] != nums.length ? nums.length : missing};
    }
}
