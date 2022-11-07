//TC : O(N)
class Solution {
    public int maximum69Number (int num) {
        String s = num + "";
        int res = num; //if num don't have any, 6s then num will be the answer
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == '6'){
                String newNum = s.substring(0, i) + '9' + s.substring(i + 1);
                res = Integer.parseInt(newNum);
                break;
            }
        }
        
        return res;
    }
}

//TC : O(N)
class Solution {
    public int maximum69Number (int num) {
        // Convert the input 'num' to a string builder 'numSB'.
        StringBuilder numSB = new StringBuilder(num + "");
        
        // Iterate over the string builer (from high to low).
        for(int i = 0; i < numSB.length(); ++i){
            // If we find the first '6', replace it with '9' and break the loop.
            char ch = numSB.charAt(i);
            if(ch == '6'){
                numSB.setCharAt(i, '9');
                break;
            }
        }
        
        // Convert the modified string builder to integer and return it.
        return Integer.parseInt(numSB.toString());
    }
}

