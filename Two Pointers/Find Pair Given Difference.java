//User function Template for Java
//target sum pair

class Solution{
    public boolean findPair(int arr[], int size, int n){
        //code here.
        Arrays.sort(arr);
        
        //both pointers will be from left to right or from right to left, in case of
        //finding pair with given difference
        int i = 0;
        int j = 1;
        
        while(j < arr.length){
            if(arr[j] - arr[i] > n){
                i++;
                if(i == j){
                    j++;
                }
            }else if(arr[j] - arr[i] < n){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }
}
