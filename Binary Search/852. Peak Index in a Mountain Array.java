//simple log(n) Solution..
//The comparison A[i] < A[i+1] in a mountain array looks like [True, True, True, ..., True, False, False, ..., False]

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(arr[mid] < arr[mid + 1]){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        
        return lo;
    }
}
