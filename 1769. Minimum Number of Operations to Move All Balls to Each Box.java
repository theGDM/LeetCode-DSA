//Brute force O(n * n)
class Solution {
    public int[] minOperations(String boxes) {
        int[] answer = new int[boxes.length()];
        
        for(int i = 0; i < boxes.length(); ++i){
            int steps = 0;
            
            //from front
            for(int j = 0; j < i; ++j){
                if(boxes.charAt(j) == '1'){
                    steps += i - j;
                }
            }
            
            //from back 
            for(int k = boxes.length() - 1; k > i; --k){
                if(boxes.charAt(k) == '1'){
                    steps += k - i;
                }
            }
            
            //finally storing the result
            answer[i] = steps;
        }
        
        return answer;
    }
}
