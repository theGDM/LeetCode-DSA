class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return helper(start, arr, visited);
    }
    
    public boolean helper(int start, int[] arr, boolean[] visited){
        if(arr[start] == 0){ //base case
            return true;
        }
        
        visited[start] = true; //mark visited
        
		//faith calls
        if(start + arr[start] <= arr.length - 1 && visited[start + arr[start]] == false){
            boolean ans = helper(start + arr[start], arr, visited);
            if(ans == true) return true;
        }
        
        if(start - arr[start] >= 0 && visited[start - arr[start]] == false){
            boolean ans = helper(start - arr[start], arr, visited);
            if(ans == true) return true;
        }
        
        return false;
    }
}
