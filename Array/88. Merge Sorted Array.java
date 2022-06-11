class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] q = new int[m + n];
        int i = 0, j = 0, k = 0;
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                q[k] = nums1[i];
                ++i;
                ++k;
            }else{
                q[k] = nums2[j];
                ++j;
                ++k;
            }
        }
        
        //if nums1 still have elements
        while(i < m){
            q[k] = nums1[i];
            ++i;
            ++k;
        }
        //if nums2 still have elements
        while(j < n){
            q[k] = nums2[j];
            ++j;
            ++k;
        }
        // nums1 = q; we can not do this as these are local changes, we need to update the
        // entire nums1 array
        for(int l = 0;l < q.length; ++l){
            nums1[l] = q[l];
        }
    }
}
