class Solution{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    //TC : nlog(n)
    static long ans;
    static long inversionCount(long arr[], long N){
        // Your Code Here
        ans = 0;
        mergeSort(0, arr.length - 1, arr);
        return ans;
    }
    
    public static long[] mergeSort(int lo, int hi, long[] arr){
        if(lo == hi){
            long[] baseArr = new long[1];
            baseArr[0] = arr[lo];
            return baseArr;
        }
        
        int mid = lo + (hi - lo) / 2;
        
        long[] fh = mergeSort(lo, mid, arr);
        long[] sh = mergeSort(mid + 1, hi, arr);
        long[] sArr = merge2SortedArray(fh, sh);
        
        return sArr;
    }
    
    public static long[] merge2SortedArray(long[] a, long[] b){
        int i = 0;
        int j = 0;
        int k = 0;
        long[] res = new long[a.length + b.length];
        
        while(i < a.length && j < b.length){
            if(a[i] <= b[j]){
                res[k++] = a[i++];
            }else{
                ans += a.length - i; //main jist
                res[k++] = b[j++];
            }
        }
        
        if(i < a.length){
            while(i < a.length){
                res[k++] = a[i++];
            }
        }
        
        if(j < b.length){
            while(j < b.length){
                res[k++] = b[j++];
            }
        }
        
        return res;
    }
}
