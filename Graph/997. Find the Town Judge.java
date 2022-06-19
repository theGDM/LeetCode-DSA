class Solution {
    //Tc = O(E + v) = O(T + N)
    public int findJudge(int n, int[][] trust) {
        int[] votes = new int[n + 1]; //how many votes person getting, here votes[i] will denote the vote i gets;
        int[] voted = new int[n + 1]; //To how may people i person voted for trust
        
        for(int i = 0; i < trust.length; ++i){
            int p1 = trust[i][0]; //person who is going to vote
            int p2 = trust[i][1]; //person who gets th vote
            
            ++votes[p2]; //person p2 getting the vote of p1 for his trust
            ++voted[p1]; //person p1 is going to vote for p2
        }
        
        for(int i = 1; i <= n; ++i){
            if(votes[i] == n - 1 && voted[i] == 0){
                return i;
            }
        }
        
        return -1;
    }
}

//more optimized
class Solution {
    //Tc = O(E + v) = O(T + N)
    //in-degree - out-degree of node = N - 1
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n + 1]; 
        //count[i] => denotes the overall in-degree of vertex i(-ve value of count[i] denotes there is no in-degree
        //and abs(count[i]) out-degree)
        for(int i = 0; i < trust.length; ++i){
            int p1 = trust[i][0]; //person who is going to vote
            int p2 = trust[i][1]; //person who gets th vote
            
            ++count[p2];
            --count[p1];
        }
        
        for(int i = 1; i <= n; ++i){
            if(count[i] == n - 1){
                return i;
            }
        }
        
        return -1;
    }
}
