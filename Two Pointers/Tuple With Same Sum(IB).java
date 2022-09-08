public class Solution {
    //TC : O(n4) worst case, when every pairs goes in the same key
    //SC : O(n2), How many pairs are stored
    public ArrayList<Integer> equal(ArrayList<Integer> A) {
        HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < A.size(); ++i){
            for(int j = i + 1; j < A.size(); ++j){
                int sum = A.get(i) + A.get(j);
                if(map.containsKey(sum) == false){
                    map.put(sum, new ArrayList<>());
                }
                map.get(sum).add(new ArrayList(Arrays.asList(i, j)));
            }   
        }
        // System.out.println(map);
        for(int i = 0; i < A.size(); ++i){
            for(int j = i + 1; j < A.size(); ++j){
                int sum = A.get(i) + A.get(j);
                if(map.get(sum).size() > 1){
                    for(ArrayList<Integer> part : map.get(sum)){ //[1,1,1,1,1,1] imp test case
                        if(i != part.get(0) && i != part.get(1) && j != part.get(0) && j != part.get(1)){
                            res.add(i);
                            res.add(j);
                            res.add(part.get(0));
                            res.add(part.get(1));
                            
                            return res;
                        }
                    }
                }
            }    
        }
        
        return res;    
    }
}
