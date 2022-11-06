//TC : O(3N)
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] temp = new int[nums.length];
        int idx = 0;
        for(int n : nums){
            if(n < pivot) temp[idx++] = n;
        }
        
        for(int n : nums){
            if(n == pivot) temp[idx++] = n;
        }
        
        for(int n : nums){
            if(n > pivot) temp[idx++] = n;
        }
        
        return temp;
    }
}

//Single traversal
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();
        int idx = 0;
        for(int n : nums){ //O(N)
            if(n == pivot) equal.add(n);
            else if(n < pivot) less.add(n);
            else greater.add(n);
        }
        
        less.addAll(equal);
        less.addAll(greater);
        
        for(int i = 0; i < nums.length; ++i){ //O(N)
            nums[i] = less.get(i);
        }
        
        return nums;
    }
}
