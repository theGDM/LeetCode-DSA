//Using Two Pointer concept
//TC : O(n)
//SC : O(1)
class Solution {
    public int compress(char[] chars) {
        int l = 0;
        int r = 0;
        
        int idx = 0;
        while(l < chars.length && r < chars.length){
            int count = 0;
            
            while(r < chars.length && chars[r] == chars[l]){ //increment the right pointer, till same group
                count++;
                r++;
            }
            
            chars[idx++] = chars[l]; //append the character
            if(count != 1){ //append the count, if its not equal to 1
                String cnt = count + "";
                for(char ch : cnt.toCharArray()){ //what if count is 12, 34, 56, 687 etc
                    chars[idx++] = ch;
                }
            }
            
            l = r; //now bring left pointer, where right is presently
        }
    
        return idx;
    }
}
