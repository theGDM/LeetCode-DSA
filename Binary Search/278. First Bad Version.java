//TLE
public class Solution extends VersionControl {
    int possibleBadVersion;
    public int firstBadVersion(int n) {
        possibleBadVersion = n;
        helper(n);
        return possibleBadVersion;
    }
    
    public void helper(int n){
        if(n == 0) return;
        
        if(isBadVersion(n) == true){
            possibleBadVersion = n;
        }
        helper(n - 1);
    }
}

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int ans = -1;
        
        while(left <= right){
            int mid = left + (right - left) / 2; // to avoid overflow incase (left+right) > 2147483647
            if(isBadVersion(mid) == true){
                ans = mid; // record mid as current answer
                right = mid - 1; // try to find smaller version in the left side
            }else{
                left = mid + 1; // try to find in the right side
            }
        }
        
        return ans;
    }
}
