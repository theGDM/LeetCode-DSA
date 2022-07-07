//brute force
class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int answer = 0;
        Arrays.sort(special);
        
        //from bottom floor to first special floor
        answer = Math.max(answer, special[0] - bottom);
        
        //from first special floor to last specila floor
        for(int i = 1; i < special.length; ++i){
            answer = Math.max(answer, special[i] - special[i - 1] - 1);
        }
        
        //from last special floor to top floor
        answer = Math.max(answer, top - special[special.length - 1]);   
        
        return answer;
    }
}
