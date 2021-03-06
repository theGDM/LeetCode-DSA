//using DSU
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */
    static int[] parent;
    static int[] rank;
    static int[] size;
    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        
        for(int i = 0; i < n; ++i){ 
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
        
        //each pair denotes the astronauts belonging to same country
        for(List<Integer> p : astronaut){
            int a1 = p.get(0);
            int a2 = p.get(1);
            
            unionHelper(a1, a2);
        }
        
        long res = 0;
        int t = n;
        for(int i = 0; i < n; ++i){
            System.out.println(size[i]);
            if(parent[i] == i){ //we must be parent
                res = res + size[i] * (t - size[i]);
                t = t - size[i];
                //this will generate the time limit exceed
                // for(int j = i + 1; j < n; ++j){
                //     if(parent[j] == j && size[j] > 0){
                //         res = res + size[i] * size[j];
                //     }
                // }
            }
        }
        return res;
    }
    
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    public static void unionHelper(int a1, int a2){
        int a1l = find(a1);
        int a2l = find(a2);
        
        if(a1l != a2l){
            if(rank[a1l] < rank[a2l]){
                parent[a1l] = a2l;
                size[a2l] += size[a1l];
            }else if(rank[a2l] < rank[a1l]){
                parent[a2l] = a1l;
                size[a1l] += size[a2l];
            }else{
                parent[a1l] = a2l;
                rank[a2l]++;
                size[a2l] += size[a1l];
            }
        }
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

//using get connected component(Similar to friend pairing)
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */
     
    public static class Edge{
        int v;
        int n;
        Edge(int v, int n){
            this.v = v;
            this.n = n;
        }
    }
    
    public static int c;
    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {      
        //each pair denotes the astronauts belonging to same country
        //making graph first
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int v = 0; v < n; ++v){
            graph.add(new ArrayList<>());
        }
        
        for(List<Integer> p : astronaut){
            int v1 = p.get(0);
            int v2 = p.get(1);
            
            graph.get(v1).add(new Edge(v1, v2));
            graph.get(v2).add(new Edge(v2, v1));
        }
        
        //get connected component
        boolean[] visited = new boolean[n];
        ArrayList<Integer> compSize = new ArrayList<>();
        for(int v = 0; v < n; ++v){
            if(visited[v] == false){
                c = 0;
                getConnectedComp(v, graph, visited);
                compSize.add(c);
            }
        }
        
        long res = 0;
        int t = n;
        for(int i = 0; i < compSize.size(); ++i){
            res = res + compSize.get(i) * (t - compSize.get(i));
            t = t - compSize.get(i);
        }
        return res;
    }
    
    public static void getConnectedComp(int v, ArrayList<ArrayList<Edge>> graph, boolean[] visited){
        visited[v] = true;
        c++;
        
        for(Edge e : graph.get(v)){
            if(visited[e.n] == false){
                getConnectedComp(e.n, graph, visited);
            }
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

