import java.io.*;
import java.util.*;
//TC : O(2^N)
public class Main {
        
    public static long partitionKSubset(int n, int k) {
        if(n == k) return 1;
        if(n < k) return 0;
        if(k == 0) return 0;
        
        long sameRoom = partitionKSubset(n - 1, k) * k;
        long newRoom = partitionKSubset(n - 1, k - 1);
        return sameRoom + newRoom;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long res = partitionKSubset(n, k);
        System.out.println(res);
    }
}
