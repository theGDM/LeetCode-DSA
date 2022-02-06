class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int i = s.length() - 1;
        //to remove spaces from end
        while(s.charAt(i) == ' '){
            --i;
        }
        
        //if we get white space first time or we hit 0 index then stop
        while(i >= 0 && s.charAt(i) != ' '){
            ++count;
            --i;
        }
        return count;
    }
}
