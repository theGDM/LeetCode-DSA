//User function Template for Java
//dependency, and ordering if string me aaye to try toplogical sort
//isme words ki ordering pata hai ,hame character ki ordering nikalni hai, ki actual
//me char ki ordering kya hai jisses ye alien order aaya
//Lekin radix sort to kebal array of sort karke degi
class Solution{
    public String findOrder(String [] dict, int N, int K){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int v = 0; v < K; ++v){
            graph.add(new ArrayList<>());
        }
        
        //a -> 0
        //b -> 1
        //c -> 2
        //d -> 3
        
        //first make the directed graph
        for(int i = 0; i < dict.length - 1; ++i){
            String w1 = dict[i];
            String w2 = dict[i + 1];
            
            for(int j = 0; j < w1.length() && j < w2.length(); ++j){
                if(w1.charAt(j) != w2.charAt(j)){
                    graph.get(w1.charAt(j) - 'a').add(w2.charAt(j) - 'a');
                    break;
                }
            } 
        }
        
        //Code to print graph
        // for(int i = 0;i < graph.size(); ++i){
        //     System.out.print(i + " -> ");
        //     for(int n : graph.get(i)){
        //         System.out.print(n + " ");
        //     }
        //     System.out.println();
        // }
        
        //then apply the topological sort
        boolean[] visited = new boolean[K];
        Stack<Integer> stk = new Stack<>();
        
        for(int v = 0; v < K; ++v){
            if(visited[v] == false){
                toplogicalSort(v, graph, visited, stk);
            }
        }
        
        String res = "";
        while(stk.size() > 0){
            res += (char)(stk.pop() + 'a');
        }
        
        // System.out.println(res);
        return res;
    }
    
    public void toplogicalSort(int v, ArrayList<ArrayList<Integer>> graph , boolean[] visited, Stack<Integer> stk){
        visited[v] = true;
        for(int n : graph.get(v)){
            if(visited[n] == false){
                toplogicalSort(n, graph, visited, stk);
            }
        }
        
        stk.add(v);
    }
}
