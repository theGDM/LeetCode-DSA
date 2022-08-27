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

//TC : O(log(m + n))
//SC : O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        int mp1 = (m + n + 1) / 2;
        int mp2 = (m + n + 2) / 2;
        
        int median1 = getKthElementFromSortedArray(nums1, nums2, mp1, 0, 0);
        int median2 = getKthElementFromSortedArray(nums1, nums2, mp2, 0, 0);

        return (median1 + median2) / 2.0;
    }
    
    //dono sorted array me se konsa kth chhota element hoga..
    public int getKthElementFromSortedArray(int[] nums1, int[] nums2, int k, int s1, int s2){
        if(s1 >= nums1.length){ //yadi pahle wali array khatam ho jaaye, to 2nd array me se kth element dena hai
            return nums2[s2 + k - 1];
        }
        
        if(s2 >= nums2.length){ //yadi 2nd wali array khatam ho jaaye, to pahli array me se kth element dena hai
            return nums1[s1 + k - 1];
        }
        
        if(k == 1){ //first element maang liya jaaye, tab dono ke start me se min return kardo
            return Math.min(nums1[s1], nums2[s2]);
        }
        
        int mid1 = k / 2 - 1 < nums1.length ? nums1[s1 + k / 2 - 1] : Integer.MAX_VALUE; //index of k / 2th element is k / 2 - 1
        int mid2 = k / 2 - 1 < nums2.length ? nums2[s2 + k / 2 - 1] : Integer.MAX_VALUE;
        
        if(mid1 < mid2){
            return getKthElementFromSortedArray(nums1, nums2, k - k / 2, s1 + k / 2, s2);
        }else{
            return getKthElementFromSortedArray(nums1, nums2, k - k / 2, s1, s2  + k / 2);
        }
    }
}
