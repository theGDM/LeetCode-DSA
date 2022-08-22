class NumArray {
    int[] arr;
    public NumArray(int[] nums) {
        arr = nums;
    }
    
    //O(1)
    public void update(int index, int val) {
        arr[index] = val;
    }
    
    //O(n)
    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i = left; i <= right; ++i){
            sum += arr[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
