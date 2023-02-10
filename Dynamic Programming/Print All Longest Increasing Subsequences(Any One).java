//TC : O(N * N * N)
//SC : O(N * N)
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

//Optimized approach
//TC : O(N * N + N)
//SC : O(N)
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    public static void solution(int[] nums){
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];
        int maxLIS = 0, maxLISidx = 0;
        for(int i = 0; i < nums.length; ++i){ //o(N*N)
            dp[i] = 1; //if prev does not exist, then current index can have LIS of length of 1
            prev[i] = -1;
            for(int j = 0; j < i; ++j){
                if(nums[j] < nums[i]){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            
            if(maxLIS < dp[i]){
                maxLIS = dp[i];
                maxLISidx = i;
            }
        }
        
        //O(N)
        ArrayList<Integer> LIS = new ArrayList<>();
        while(maxLISidx != -1){
            LIS.add(0, nums[maxLISidx]);
            maxLISidx = prev[maxLISidx];
        }
        
        System.out.println(maxLIS);
        for(int i = 0; i < LIS.size(); ++i){
            int val = LIS.get(i);
            if(i == LIS.size() - 1){
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
