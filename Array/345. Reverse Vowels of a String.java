//TC : O(N)
//SC : O(N)
class Solution {
    public String reverseVowels(String s) {
        int l = 0, r = s.length() - 1;
        char[] arr = s.toCharArray();
        while(l < r){
        
            while(l < r && arr[l] != 'a' && arr[l] != 'e' && arr[l] != 'i' && arr[l] != 'o' && arr[l] != 'u'
                        && arr[l] != 'A' && arr[l] != 'E' && arr[l] != 'I' && arr[l] != 'O' && arr[l] != 'U'){
                l++;
            }
            
            while(l < r && arr[r] != 'a' && arr[r] != 'e' && arr[r] != 'i' && arr[r] != 'o' && arr[r] != 'u'
                        && arr[r] != 'A' && arr[r] != 'E' && arr[r] != 'I' && arr[r] != 'O' && arr[r] != 'U'){
                r--;
            }
            
            swap(arr, l, r);
            l++; r--;
        }
        
        return new String(arr);
    }
    
    public void swap(char[] arr, int l, int r){
        char temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
