//TC : O(n)
//SC : O(1)
class Complete{
    // Function for finding maximum and value pair
    public static int minSwap (int arr[], int N, int k) {
        //calculate window size
        int win = 0;
        for(int num : arr){
            if(num <= k){
                win++;
            }
        }
        
        //checking no of elements <= k, in the first window
        int lessThanK = 0;
        for(int i = 0; i < win; ++i){
            if(arr[i] <= k){
                lessThanK++;
            }
        }
        
        int minSwaps = win - lessThanK; //answer for the first window
        
        for(int i = win; i < N; ++i){
            int inc = arr[i];
            int exc = arr[i - win];
            
            if(inc <= k){ //if including element is less than k, than increase the count of lessThanK
                lessThanK += 1;
            }
            
            if(exc <= k){ //if excluding element is less than k, than decrease the count of lessThanK
                lessThanK -= 1;
            }
            
            minSwaps = Math.min(minSwaps, win - lessThanK);
        }
        
        return minSwaps;
    }
}


//TC : O(n)
//SC : O(1)
class Complete{
    // Function for finding maximum and value pair
    public static int minSwap (int arr[], int N, int k) {
        //calculate window size
        int win = 0;
        for(int num : arr){
            if(num <= k){
                win++;
            }
        }
        
        //checking no of elements <= k, in the first window
        int moreThanK = 0;
        for(int i = 0; i < win; ++i){
            if(arr[i] > k){
                moreThanK++;
            }
        }
        
        
        int minSwaps = moreThanK; //answer for the first window
        
        for(int i = win; i < N; ++i){
            int inc = arr[i];
            int exc = arr[i - win];
            
            if(inc > k){ //if including element is greater than k, than increase the count of moreThanK
                moreThanK += 1;
            }
            
            if(exc > k){ //if excluding element is greater than k, than decrease the count of moreThanK
                moreThanK -= 1;
            }
            
            minSwaps = Math.min(minSwaps, moreThanK);
        }
        
        return minSwaps;
    }
}

