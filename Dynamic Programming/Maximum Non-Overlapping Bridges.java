import java.io.*;
import java.util.*;

public class Main {
    public static class Pair{
        int n;
        int s;

        Pair(int n, int s){
            this.n = n;
            this.s = s;
        }

        public String toString(){
            return "[" + this.n + " , " + this.s + "]";
        }
    }
    
    //Sorting on the basis of northern bank co-ordinates of bridge
    //and applying LIS on southern banck co-ordinates of bridge
    public static class MyComparable implements Comparator<Pair>{
        public int compare(Pair p1, Pair p2){
            if(p1.n != p2.n){
                return p1.n - p2.n;
            }else{
                return p1.s - p2.s;
            }
        }
    }
  
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(reader.readLine());
        Pair[] bridges = new Pair[n];

        for(int i = 0; i < n; ++i){
            String str = reader.readLine();
            String[] parts = str.split(" ");
            int nc = Integer.parseInt(parts[0]);
            int sc = Integer.parseInt(parts[1]);
            bridges[i] = new Pair(nc, sc); 
        }

        Arrays.sort(bridges, new MyComparable());
        // System.out.println(Arrays.toString(bridges));

        int[] LIS = new int[bridges.length];
        LIS[0] = 1;

        for(int i = 1; i < bridges.length; ++i){
            int max = 0;
            for(int j = 0; j < i; ++j){
                if(bridges[j].s <= bridges[i].s){
                    max = Math.max(max, LIS[j]);
                }
            }

            LIS[i] = max + 1;
        }
        
        int ans = 0;
        for(int i = 0; i < LIS.length; ++i){
            ans = Math.max(ans, LIS[i]);
        }

        System.out.println(ans);        
    }

}
