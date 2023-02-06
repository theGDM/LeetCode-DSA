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

