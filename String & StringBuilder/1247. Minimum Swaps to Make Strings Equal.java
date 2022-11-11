//TC : O(N), Greedy Solution
class Solution {
    public int minimumSwap(String s1, String s2) {
        int x1 = 0; //Number of xs in String s1
        int y1 = 0; //Number of ys in String s1
        int x2 = 0; //Number of xs in String s2
        int y2 = 0; //Number of ys in String s2
        
        for(int i = 0; i < s1.length(); ++i){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            // skip chars that are equal at the same index in s1 and s2
            if(c1 == c2) continue;
            
            if(c1 == 'x') x1++;
            else y1++;
            
            if(c2 == 'x') x2++;
            else y2++;
        }
        
        // System.out.println(x1 + " " + x2);
        // System.out.println(y1 + " " + y2);
        // After skip "c1 == c2", check the number of  'x' and 'y' left in s1 and s2.
        if((x1 + x2) % 2 != 0 || (y1 + y2) % 2 != 0){
            return -1; //we can not make them equal
        }
        
        int swaps = x1 / 2 + y1 / 2 + (x1 % 2) * 2;
        // Cases to do 1 swap:
        // "xx" => x1 / 2 => how many pairs of 'x' we have ?
        // "yy" => y1 / 2 => how many pairs of 'y' we have ?
        // 
        // Cases to do 2 swaps:
        // "xy" or "yx" =>  x1 % 2
        return swaps;    
    }
}

// Observation from given example
//     case 1:
//     xx
//     yy => minimum swap is 1

//     case 2:
//     xy
//     yx => minimum swap is 2

//     case 3:
//     xx
//     xy => not possible [If we have odd no of sum of x/y in both strings then it is impossible to make them equal ]
