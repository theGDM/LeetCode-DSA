class Solution{
    //Function to arrange all letters of a string in lexicographical 
    //order using Counting Sort.
    public static String countSort(String arr){
        int[] freq = new int[26];
        
        //step 1 : makingg the frequency array
        for(int i = 0; i < arr.length(); ++i){
            char ch = arr.charAt(i);
            freq[ch - 'a']++;
        }
        
        //step 2 : making the prefix sum array
        int[] preSum = new int[freq.length];
        preSum[0] = freq[0];
        for(int i = 1; i < freq.length; ++i){
            preSum[i] = preSum[i - 1] + freq[i];
        }
        
        //step 3 : making the res array of the size of arr
        char[] res = new char[arr.length()];
        for(int i = arr.length() - 1; i >= 0; --i){
            --preSum[arr.charAt(i) - 'a'];
            int idx = preSum[arr.charAt(i) - 'a'];
            res[idx] = arr.charAt(i);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.length; ++i){
            sb.append(res[i]);
        }
        
        return sb.toString();
    }
}
