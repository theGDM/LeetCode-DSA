//DFS
import java.io.*;
import java.util.*;

public class Main {

    public static class Pair{
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int target = Integer.parseInt(br.readLine());

        int[][] dp = new int[arr.length + 1][target + 1];
        for(int idx = 0; idx <= arr.length; ++idx){
            for(int sum = 0; sum <= target; ++sum){
                if(idx == 0 && sum == 0){
                    dp[idx][sum] = 1;
                    continue;
                }
                
                if(idx == 0){
                    dp[idx][sum] = 0;
                    continue;
                }
                
                int no = dp[idx - 1][sum];
                int yes = 0;
                if(sum - arr[idx - 1] >= 0){
                    yes = dp[idx - 1][sum - arr[idx - 1]];
                }
                
                dp[idx][sum] = (yes + no) % 1000000007;
            } 
        }

        if(dp[arr.length][target] == 0) return;
        else System.out.println(true);
        
        DFS(arr.length, target, "", arr, dp);
    }
    
    public static void DFS(int row, int col, String psf, int[] arr, int[][] dp){
        if(row == 0){
            System.out.println(psf);
            return;
        }
        
        //no
        if(dp[row - 1][col] != 0){
            DFS(row -1, col, psf, arr, dp);
        }
        
        //yes call
        if(col - arr[row - 1] >= 0 && dp[row - 1][col - arr[row - 1]] > 0){
            DFS(row - 1, col - arr[row - 1], (row - 1) + " " + psf, arr, dp);
        }
    }
}

//BFS
import java.io.*;
import java.util.*;

public class Main {

    public static class Pair{
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int target = Integer.parseInt(br.readLine());

        int[][] dp = new int[arr.length + 1][target + 1];
        for(int idx = 0; idx <= arr.length; ++idx){
            for(int sum = 0; sum <= target; ++sum){
                if(idx == 0 && sum == 0){
                    dp[idx][sum] = 1;
                    continue;
                }
                
                if(idx == 0){
                    dp[idx][sum] = 0;
                    continue;
                }
                
                int no = dp[idx - 1][sum];
                int yes = 0;
                if(sum - arr[idx - 1] >= 0){
                    yes = dp[idx - 1][sum - arr[idx - 1]];
                }
                
                dp[idx][sum] = (yes + no) % 1000000007;
            } 
        }
        
        if(dp[arr.length][target] == 0) return;
        else System.out.println(true);
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(arr.length, target, ""));
        
        while(q.size() > 0){
            Pair rem = q.remove();
            int row = rem.i;
            int col = rem.j;
            String psf = rem.psf;
            if(row == 0){ //reached to the first coloumn
                System.out.println(psf);
                continue;
            }
            
            //No call
            if(dp[row - 1][col] != 0){
                q.add(new Pair(row - 1, col, psf));
            }
            
            //yes call
            if(col - arr[row - 1] >= 0 && dp[row - 1][col - arr[row - 1]] > 0){
                q.add(new Pair(row - 1, col - arr[row - 1], (row - 1) + " " + psf));
            }
    
        }
    }
}
