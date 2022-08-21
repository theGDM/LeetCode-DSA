class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        int mp1 = (m + n + 1) / 2;
        int mp2 = (m + n + 2) / 2;
        
        int median1 = getKthElementFromSortedArray(nums1, nums2, mp1);
        int median2 = getKthElementFromSortedArray(nums1, nums2, mp2);
        System.out.println(median1 + " " + median2);
        return (median1 + median2) / 2.0;
    }
    
    //dono sorted array me se konsa kth chhota element hoga..
    public int getKthElementFromSortedArray(int[] nums1, int[] nums2, int k){
        int n = 0;
        int i = 0;
        int j = 0;
        //using merging two sorted array concept
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                n++;
                i++;
                if(n == k) return nums1[i - 1];
            }else{
                n++;
                j++;
                if(n == k) return nums2[j - 1];
            }
        }
        
        while(i < nums1.length){
            n++;
            i++;
            if(n == k) return nums1[i - 1];
        }
        
        while(j < nums2.length){
            n++;
            j++;
            if(n == k) return nums2[j - 1];
        }
        
        return -1;
    }
}

