//User function Template for Java
//A graph having euler circuit will also have the the euler path,
//and also in a graph if there exist only two vertex ahving odd degree, will aalso
//have the euler path.
class Solution{
    static int eulerPath(int N, int graph[][]){
        int vertexWithOddDegree = 0;
        for(int i = 0; i < graph.length; ++i){
            int degreeCount = 0; //degree count of each vetex
            for(int j = 0; j < graph[0].length; ++j){
                if(i != j && graph[i][j] == 1){
                    ++degreeCount;
                }
            }
            
            if(degreeCount % 2 == 1){//count vertex with odd degree
                ++vertexWithOddDegree;
            }
        }
        
        if(vertexWithOddDegree == 0 || vertexWithOddDegree == 2){
            return 1;
        }else{
            return 0;
        }
    }
}
