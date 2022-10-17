//TC : O(n)
//SC : O(1)
class Solution {
    public boolean validMountainArray(int[] arr) {
        int state = 1; //state for strictly increasing array
        int c1 = 0;
        int c2 = 0;
        for(int i = 1; i < arr.length; ++i){
            // System.out.println(c1 + " " + c2);
            if(state == 1 && arr[i] > arr[i - 1]){ //state 1,  and strictly increasing
                c1++;
            }else if(state == 1 && arr[i] < arr[i - 1]){ //first time dip
                state++; //now enter in strictly decreasing state
                c2++;
            }else if(state == 2 && arr[i] < arr[i - 1]){
                c2++;
            }else{ //if any other options , like plateus arr[i] = arr[i - 1], also other state > 2
                return false;
            }
        }
        
        if(c1 >= 1 && c2 >= 1) return true;
        else return false;
    }
}

//TC : O(n)
//SC : O(1)
class Solution {
    public boolean validMountainArray(int[] a) {
        int N = a.length;
        int i = 0;
        
        //walk up
        while(i + 1 < N && a[i] < a[i + 1]) i++;
        
        //peak of mountail can't be at first or at last
        if(i == 0 || i == N - 1) return false;
        
        //walk down 
        while(i + 1 < N && a[i] > a[i + 1]) i++;
        
        return i == N - 1;
    }
}
