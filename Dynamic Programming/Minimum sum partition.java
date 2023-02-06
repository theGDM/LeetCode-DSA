//TC : O(2^N)
class Solution{
    public int minDiff;
    public int minDifference(int arr[], int n){ 
	    minDiff = Integer.MAX_VALUE;
	    helper(0, 0, 0, arr);
	    return minDiff;
	} 
	
	public void helper(int idx, int s1, int s2, int[] arr){
	    if(idx == arr.length){
	        minDiff = Math.min(minDiff, Math.abs(s1 - s2));
	        return;
	    }
	    
	    //include current index in s1 set
	    helper(idx + 1, s1 + arr[idx], s2, arr);
	    //if not including current index element in s1, then it will go in s2
	    helper(idx + 1, s1, s2 + arr[idx], arr);
	}
}

//TC : O(N * total) + O(total)
class Solution{
    public int minDifference(int arr[], int n){ 
	    int total = getSum(arr);
	    boolean[] dp = new boolean[total + 1];
	    dp[0] = true;
        for(int idx = 1; idx <= arr.length; ++idx){
            boolean[] newDp = new boolean[total + 1];
            for(int sum = 0; sum <= total; ++sum){
                boolean no = dp[sum];
                boolean yes = false;
                if(sum - arr[idx - 1] >= 0){
                    yes = dp[sum - arr[idx - 1]];
                }
                
                newDp[sum] = yes || no;
            } 
            
            dp = newDp;
        }
        
        for(int s1 = (total + 1) / 2; s1 <= total; ++s1){
            if(dp[s1] == true){
                int s2 = total - s1;
                return s1 - s2;
            }
        }
        
        return total;
	}
    
    public int getSum(int[] arr){
        int sum = 0;
        for(int n : arr){
            sum += n;
        }
        return sum;
    }
}
