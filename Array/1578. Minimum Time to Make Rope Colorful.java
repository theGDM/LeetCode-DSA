//O(n) approch
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int minTime = 0;
        for(int i = 0; i < colors.length() - 1; ++i){
            if(colors.charAt(i) == colors.charAt(i + 1)){
                if(neededTime[i] < neededTime[i + 1]){
                    minTime += neededTime[i];
                }else{
                    minTime += neededTime[i + 1];
                    // move ith index value to (i+1)th index for comparison
                    // in next iteration
                    neededTime[i + 1] = neededTime[i]; //"aaabbbabbbb" [3,5,10,7,5,3,5,5,4,8,1]
                }
            }
        }
        
        return minTime;
    }
}

//Grouping Method (Two Pointer)
//TC : O(n) approch
//SC : O(1)
//No, it is never optimal to delete a whole group. Imagine we remove a whole group group and end up with a total removal time t. 
//Now suppose that we keep one balloon from group, the string is still colorful and we end up with a smaller removal time t' (t' < t), since we remove one less 
//balloon this time.
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int minTime = 0;
        int l = 0, r = 0;
        
        while(l < neededTime.length && r < neededTime.length){
            int currMax = 0; //maximum from each group
            int currTotal = 0; //sum of removal time of entire ballons of group, and at the last we keep the only
            //one ballon from the group having maximum removal time
            
            while(r < neededTime.length && colors.charAt(l) == colors.charAt(r)){
                currTotal += neededTime[r];
                currMax = Math.max(currMax, neededTime[r]);
                r++;
            }
            
            // Once we reach the end of the current group, add the cost of this group to mintime, and reset 
            //two pointers.
            minTime += currTotal - currMax;
            l = r;
        }
        
        return minTime;
    }
}
