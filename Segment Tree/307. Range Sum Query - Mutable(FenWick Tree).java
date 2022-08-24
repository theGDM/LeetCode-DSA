//Fenwick array works on position not on indexs
class NumArray {
    public class FenWick{
        int[] farr;
        
        FenWick(int[] nums){
            this.farr = new int[nums.length + 1];
            
            for(int i = 0; i < nums.length; ++i){
                int pos = i + 1;
                int val = nums[i];
                this.update(pos, val);
            }
        }
        
        public int sum(int pos){ //give sum upto this pos, (1 - 20), (1 - 8)
            int res = 0;
            while(pos > 0){
                res += farr[pos];
                pos = pos - rsb(pos);
            }
            
            return res;
        }
        
        public void update(int pos, int delta){
            while(pos < farr.length){
                farr[pos] += delta;
                pos = pos + rsb(pos);
            }
        }
        
        private int rsb(int x){ //get right significant bit
            return x & (-x); //
        }
    }
    
    int[] oarr;
    FenWick ft;
    public NumArray(int[] nums) {
        ft = new FenWick(nums);
        oarr = nums;
    }
    
    public void update(int index, int val) {
        int delta = val - oarr[index];
        int pos = index + 1;
        ft.update(pos, delta); //update farr
        oarr[index] = val; //update oarr
    }
    
    public int sumRange(int left, int right) {
        int lpos = left + 1;
        int rpos = right + 1;
        
        int sumBeforeLeft = ft.sum(lpos - 1);
        int sumTillRight = ft.sum(rpos);
        
        return sumTillRight - sumBeforeLeft;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
