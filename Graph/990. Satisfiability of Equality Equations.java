//Disjoint set union concept
//first, process all the equation with equlaity sign
//second, process all the equation with inequality sign
//if two operands in not equal condition, belong to the same set, that means, our previously made relation
//was invalid, hence return false;
class Solution {
    public boolean equationsPossible(String[] equations) {
        rank = new int[26];
        parent = new int[26];
        
        for(int i = 0; i < 26; ++i){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(String equation : equations){
            if(equation.charAt(1) == '='){
                int op1 = equation.charAt(0) - 'a';
                int op2 = equation.charAt(3) - 'a';
                
                int l1 = find(op1);
                int l2 = find(op2);
                
                if(l1 != l2){
                    union(l1, l2);
                }
            }
        }
        
        for(String equation : equations){
            if(equation.charAt(1) == '!'){
                int op1 = equation.charAt(0) - 'a';
                int op2 = equation.charAt(3) - 'a';
                
                int l1 = find(op1);
                int l2 = find(op2);
                
                if(l1 == l2){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    int[] rank;
    int[] parent;
    
    public int find(int x){
        if(parent[x] == x){
            return x;
        }else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    public void union(int l1, int l2){
        if(rank[l1] < rank[l2]){
            parent[l1] = l2;
        }else if(rank[l2] < rank[l1]){
            parent[l2] = l1;
        }else{
            parent[l1] = l2;
            rank[l2]++;
        }
    }
}
