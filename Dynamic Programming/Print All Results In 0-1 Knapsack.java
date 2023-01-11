import java.io.*;
import java.util.*;

public class Main {
  public static class Pair {
    int row;
    int col;
    String psf;

    Pair(int row, int col, String psf) {
      this.row = row;
      this.col = col;
      this.psf = psf;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] costs = new int[n];
    String str1 = br.readLine();
    for (int i = 0; i < n; i++) {
      costs[i] = Integer.parseInt(str1.split(" ")[i]);
    }

    int[] wt = new int[n];
    String str2 = br.readLine();
    for (int i = 0; i < n; i++) {
      wt[i] = Integer.parseInt(str2.split(" ")[i]);
    }

    int capacity = Integer.parseInt(br.readLine());

    int[][] dp = new int[capacity + 1][costs.length + 1];
    for (int item = 0; item <= costs.length; ++item) {
      for (int cap = 0; cap <= capacity; ++cap) {
        if (item == 0 || cap == 0) {
          dp[cap][item] = 0;
          continue;
        }

        int yes = -1;
        if (cap - wt[item - 1] >= 0) {
          yes = dp[cap - wt[item - 1]][item - 1] + costs[item - 1];
        }

        int no = dp[cap][item - 1];
        dp[cap][item] = Math.max(yes, no);
      }
    }

    System.out.println(dp[capacity][costs.length]);

    Queue<Pair> q = new ArrayDeque<>();
    q.add(new Pair(capacity, costs.length, ""));
    while (q.size() > 0) {
      Pair rem = q.remove();
      int row = rem.row;
      int col = rem.col;
      String psf = rem.psf;

      if (col == 0) {
        System.out.println(psf);
        continue;
      }
      
      //if item can be included and it gives maximum profit, then explore this edge
      if (row - wt[col - 1] >= 0 && dp[row][col] == dp[row - wt[col - 1]][col - 1] + costs[col - 1]) {
        q.add(new Pair(row - wt[col - 1], col - 1, (col - 1) + " " + psf));
      }
      
      //if no call gives maximum profit then only explore this edge
      if (dp[row][col] == dp[row][col - 1]) {
        q.add(new Pair(row, col - 1, psf));
      }
    }
  }
}
