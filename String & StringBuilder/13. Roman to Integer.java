//TC : O(N)
//SC : O(N)
class Solution {
    public int romanToInt(String s) {
         int[] map = new int[s.length()];
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            switch(ch){
                case 'M' : 
                    map[i] = 1000;
                    break;
                case 'D' :
                    map[i] = 500;
                    break;
                case 'C' :
                    map[i] = 100;
                    break;
                case 'L' :
                    map[i] = 50;
                    break;
                case 'X' :
                    map[i] = 10;
                    break;
                case 'V' :
                    map[i] = 5;
                    break;
                case 'I' :
                    map[i] = 1;
                    break;          
            }
        }
        
        int num = 0;
        for(int i = 0; i < map.length - 1; ++i){
            if(map[i] < map[i + 1]){
                num -= map[i];
            }else{
                num += map[i];
            }
        }
            
        return num + map[map.length - 1];
    }
}
