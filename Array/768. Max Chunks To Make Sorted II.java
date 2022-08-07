//TC : O(n);
//SC : O(n)
)class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] maxfromleft = new int[arr.length];
        int[] minfromRight = new int[arr.length];
        
        maxfromleft[0] = arr[0];
        for(int i = 1; i < arr.length; ++i){
            maxfromleft[i] = Math.max(maxfromleft[i - 1], arr[i]);
        }
        
        minfromRight[arr.length - 1] = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; --i){
            minfromRight[i] = Math.min(minfromRight[i + 1], arr[i]);
        }
        
        int count = 0;
        for(int i = 0; i < arr.length - 1; ++i){
            if(maxfromleft[i] <= minfromRight[i + 1]){
                count++;
            }
        }
        
        return count + 1;
    }
}
