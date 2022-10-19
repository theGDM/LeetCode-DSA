//TC : O(N)
public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) { //O(N)
        StringBuilder res = new StringBuilder();
        for(String str : strs){
            res.append(str.length()); //Next how many characters we need to extract after we have found #
            res.append('#'); //delimitor
            res.append(str); //append the str
        }
        return res.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) { //O(N)
        // write your code here
        List<String> res = new ArrayList<>();
        int j = 0;
        while(j < str.length()){
            int num = 0;
            StringBuilder part = new StringBuilder();
            boolean found = false;
            while(j < str.length() && str.charAt(j) >= '0' && str.charAt(j) <= '9'){ //collecting the digit
                found = true;
                int digit = str.charAt(j) - '0';
                num = num * 10 + digit;
                j++;
            }

            if(j < str.length() && str.charAt(j) == '#'){
                j++; //reaching starting index of word
                int start = j;
                while(j < start + num){
                    part.append(str.charAt(j));
                    j++;
                }
                res.add(part.toString());
            }else{
                j++;
            }
        }

        return res;
    }
}
