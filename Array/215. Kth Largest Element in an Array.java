//Avg TC : O(N)
//Quick Select Algorithm
//Recurrence relation : T(n) = T(n / 2) + O(n) ~ O(n)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    public int quickSelect(int[] arr, int lo, int hi, int k){        
        int pivotIdx = partition(arr, lo, hi);
     
        if(arr.length - pivotIdx == k){
            return arr[pivotIdx];
        }else if(arr.length - pivotIdx < k){
            return quickSelect(arr, lo, pivotIdx - 1, k);
        }else{
            return quickSelect(arr, pivotIdx + 1, hi, k);
        }
    }
    
    public int partition(int[] arr, int lo, int hi){ //O(n)
        int l = lo, r = lo;
        int pivot = arr[hi];
        
        while(r <= hi){
            if(arr[r] > pivot){
                r++;
            }else{
                swap(l, r, arr);
                l++;
                r++;
            }
        }

        return l - 1;
    }
    
    public void swap(int l, int r, int[] arr){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
