class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    //Bubble sort //O(n2)
    public int[] sortArray(int[] nums) {
        for(int itr = 1; itr <= nums.length; ++itr){
            int count = 0;
            for(int j = 0; j < nums.length - itr; ++j){
                if(nums[j] > nums[j + 1]){
                    count++;
                    swap(nums, j, j + 1);
                }
            }
            
            if(count == 0) break; //array is already sorted, so stop further iterations
        }
        
        return nums;
    }
    
    //Selection sort //O(n2)
    public int[] sortArray(int[] nums) {
        for(int i = 0; i < nums.length; ++i){
            int minIdx = i; //assume current index is index of (i + 1)th smallest element
            for(int j = i + 1; j < nums.length; ++j){
                if(nums[j] < nums[minIdx]){
                    minIdx = j;
                }
            }
            
            if(minIdx != i){
                swap(nums, i, minIdx);
            }
        }
        
        return nums;
    }
    
    
    //insertion sort //O(n2)
    public int[] sortArray(int[] nums) {
        for(int i = 1; i < nums.length; ++i){
            for(int j = i; j > 0; --j){
                if(nums[j - 1] > nums[j]){
                    swap(nums, j - 1, j);
                }else{
                    break;
                }
            }
        }
        
        return nums;
    }
    
    //Quick sort
    //Average case : O(nlogn)
    //Worst case : O(n2) //when array is already sorted
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    public void quickSort(int[] nums, int lo, int hi){
        if(lo >= hi){
            return;
        }
        
        int pivotIdx = partition(nums, nums[hi], lo, hi);
        quickSort(nums, lo, pivotIdx - 1);
        quickSort(nums, pivotIdx + 1, hi);
    }
    
    public int partition(int[] nums, int pivot, int lo, int hi){
        int i = lo, j = lo;
        
        while(j <= hi){
            if(nums[j] <= pivot){
                swap(nums, i, j);
                i++;
                j++;
            }else{
                j++;
            }
        }
        
        return i - 1; //important
    }
    
    //merge sort, worst case : O(nlogn)
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    public int[] mergeSort(int[] nums, int lo, int hi){
        if(lo == hi){
            int[] base = new int[1];
            base[0] = nums[lo];
            return base;
        }
        
        int mid = lo + (hi - lo) / 2;
        
        int[] left = mergeSort(nums, lo, mid);
        int[] right = mergeSort(nums, mid + 1, hi);
        
        return merge2SortedArray(left, right);
    }   
    
    public int[] merge2SortedArray(int[] a, int[] b){
        int i = 0;
        int j = 0;
        int k = 0;
        int[] c = new int[a.length + b.length];
        
        while(i < a.length && j < b.length){
            if(a[i] <= b[j]){
                c[k++] = a[i++];
            }else{
                c[k++] = b[j++];
            }
        }
        
        if(i < a.length){
            while(i < a.length){
                c[k++] = a[i++];
            }
        }
        
        if(j < b.length){
            while(j < b.length){
                c[k++] = b[j++];
            }
        }
        
        return c;
    }
}
