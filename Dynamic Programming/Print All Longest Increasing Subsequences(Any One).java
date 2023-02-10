import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main{    
    public static void solution(int[] nums){
        ArrayList<Integer>[] dp = new ArrayList[nums.length];
        int maxLIS = 0, maxLISidx = 0;
        for(int i = 0; i < nums.length; ++i){
            dp[i] = new ArrayList<>();
            dp[i].add(nums[i]);
            for(int j = 0; j < i; ++j){
                if(nums[j] < nums[i]){
                    if(dp[j].size() + 1 > dp[i].size()){
                        dp[i] = new ArrayList(dp[j]); //deep copy
                        dp[i].add(nums[i]);
                    }
                }
            }
            
            if(dp[i].size() > maxLIS){
                maxLIS = dp[i].size();
                maxLISidx = i;
            }
        }
        
        System.out.println(maxLIS);
        for(int i = 0; i < dp[maxLISidx].size(); ++i){
            int val = dp[maxLISidx].get(i);
            if(i == dp[maxLISidx].size() - 1){
                System.out.print(val);
            }else{
                System.out.print(val + " -> ");
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
