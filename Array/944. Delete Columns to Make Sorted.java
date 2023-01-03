//TC : O(N * (n + n + nlogn + n)), N is length of word, n is length of array
//TC : O(N * (3n + nlogn)) ~ O(N * n * (3 + logn)) ~ O(N * n * (3 + 7)) ~ O(1000 * 100 * 10) 
//SC : O(n)
class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for(int i = 0; i < strs[0].length(); ++i){
            char[] arr = new char[strs.length];
            
            for(int j = 0; j < strs.length; ++j){ //O(n)
                arr[j] = strs[j].charAt(i);
            }
            
            String str1 = String.valueOf(arr); //getting string from the coloumn array //O(n)
            Arrays.sort(arr); //O(nlogn)
            String str2 = String.valueOf(arr); //O(n)
            if(str1.equals(str2) == false){
                count++;
            }
        }
        
        return count;
    }
}
