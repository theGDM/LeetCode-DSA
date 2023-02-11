import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    public static void DFS(int curr, int[] nums, int[] dp, String psf){
        if(dp[curr] == 1){
            System.out.println(psf);
            return;
        }
        
        for(int prev = curr - 1; prev >= 0; --prev){
            if(nums[prev] < nums[curr] && dp[curr] == dp[prev] + 1){
                DFS(prev, nums, dp, nums[prev] + " -> " + psf);
            }
        }
    }
    
    public static void solution(int[] nums){
        int[] dp = new int[nums.length];
        int maxLIS = 0;
        for(int i = 0; i < nums.length; ++i){
            dp[i] = 1;
            for(int j = 0; j < i; ++j){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        
        System.out.println(maxLIS);
        for(int i = nums.length - 1; i >= 0; --i){
            //start dfs from each index, at which increasing subsequence of
            //longest length
            if(dp[i] == maxLIS){
                DFS(i, nums, dp, nums[i] + "");
            }
        }
    }
    
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        solution(arr);
        scn.close();
    }
}
