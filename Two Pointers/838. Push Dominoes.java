//TC : O(n)
class Solution {
    public String pushDominoes(String dominoes) {
        dominoes = "L" + dominoes + "R"; //so we don't have to do extra work
        char[] arr = dominoes.toCharArray();
        int i = 0;
        
        for(int j = 1; j < arr.length; ++j){
            if(arr[j] == 'L'){
                if(arr[i] == 'L'){
                    for(int k = i + 1; k < j; ++k){
                        arr[k] = 'L';
                    }
                }else if(arr[i] == 'R'){
                    int p = i + 1;
                    int q = j - 1;
                    
                    while(p < q){
                        arr[p] = 'R';
                        arr[q] = 'L';
                        p++;
                        q--;
                    }
                }
                
                i = j; //update i pointer
            }else if(arr[j] == 'R'){
                if(arr[i] == 'L'){
                    //do nothing
                }else if(arr[i] == 'R'){
                    for(int k = i + 1; k < j; ++k){
                        arr[k] = 'R';
                    }
                }
                
                i = j; //update i pointer
            }
        }
        
        StringBuilder ans = new StringBuilder();
        for(int j = 1; j < arr.length - 1; ++j){
            ans.append(arr[j]);
        }
        
        return ans.toString();
    }
}
