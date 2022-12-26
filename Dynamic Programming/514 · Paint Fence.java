//TC : O(N * 2)
//SC : O(N)
public class Solution {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        if(n == 1) return k;
        if(n == 2) return k * k;
        if(k == 1) return 0;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return memo(n, k, dp);
    }

    public int memo(int n, int k, int[] dp){
        if(n == 1) return dp[n] = k;
        if(n == 2) return dp[n] = k * k;

        if(dp[n] != -1) return dp[n];

        int lastTwoDiff = (k - 1) * memo(n - 1, k, dp);
        int lastTwoSame = (k - 1) * memo(n - 2, k, dp);

        return dp[n] = lastTwoDiff + lastTwoSame;
    }
}

//TC : O(N)
//SC : O(N)
public class Solution {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        if(n == 1) return k;
        if(n == 2) return k * k;
        if(k == 1) return 0;

        int[] same = new int[n + 1];
        int[] diff = new int[n + 1];
        same[2] = k;
        diff[2] = k * (k - 1);

        for(int i = 3; i <= n; ++i){
            same[i] = diff[i - 1];
            diff[i] = (same[i - 1] + diff[i - 1]) * (k - 1);
        }

        return same[n] + diff[n];
    }
}

//space optimization
//TC : O(N)
//SC : O(N)
public class Solution {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        if(n == 1) return k;
        if(n == 2) return k * k;
        if(k == 1) return 0;

        int same = k;
        int diff = k * (k - 1);

        for(int i = 3; i <= n; ++i){
            int newSame = diff;
            int newDiff = (same + diff) * (k - 1);

            same = newSame;
            diff = newDiff;
        }

        return same + diff;
    }
}
