//TC : O(words.length * 12) = O(n)
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> hs = new HashSet<>(); //it will have the unique morse code
        for(int i = 0; i < words.length; ++i){
            String w = words[i];
            
            StringBuilder sb = new StringBuilder(); //to reduce time complexity
            for(char ch : w.toCharArray()){
                sb.append(morse[ch - 'a']);
            }
            
            hs.add(sb.toString()); //add in the hashset
        }
        
        return hs.size(); //return its size, as it have only unique morse code;
    }
}
