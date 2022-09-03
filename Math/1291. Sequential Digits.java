//TC : O(1)
//SC : O(1)
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
      //All Possible combination
        int[] allNums = {
            12, 23, 34, 45, 56, 67, 78, 89,
            123, 234, 345, 456, 567, 678, 789, 
            1234, 2345, 3456, 4567, 5678, 6789, 
            12345, 23456, 34567, 45678, 56789,
            123456, 234567, 345678, 456789,
            1234567, 2345678, 3456789,
            12345678, 23456789,
            123456789
        };
        
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < allNums.length; ++i){
            if(allNums[i] < low) continue;
            if(allNums[i] > high) break;
            res.add(allNums[i]);
        }
        
        return res;
    }
}

// Time Complexity :- BigO(1), because low & high are in range of 10^2 <= l,h <= 10^9 and it is constant
// Space Complexity :- BigO(1) as space we are just using the list that we want to return. So, if you dont count that space it it will be constant then
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        int l = (low + "").length();
        int h = (high + "").length();
        System.out.println(l + " " + h);
        List<Integer> res = new ArrayList<>();
        for(int i = l; i <= h; ++i){
            for(int j = 0; j <= 9 - i; ++j){
                int digit = Integer.parseInt(digits.substring(j, j + i));
                if(digit >= low && digit <= high) res.add(digit);
            }
        }
        
        return res;
    }
}
