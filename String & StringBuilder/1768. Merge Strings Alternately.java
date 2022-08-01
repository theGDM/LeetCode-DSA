//O(n) solution
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(i < word1.length() && j < word2.length()){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            
            i++;
            j++;
        }
        
        if(i < word1.length()){
            String rem = word1.substring(i);
            sb.append(rem);
        }else if(j < word2.length()){
            String rem = word2.substring(j);
            sb.append(rem);
        }
        
        return sb.toString();
    }
}


//O(n) solution
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(i < word1.length() && j < word2.length()){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            
            i++;
            j++;
        }
        
        if(i < word1.length()){
            while(i < word1.length()){
                sb.append(word1.charAt(i));
                i++;
            }
        }else if(j < word2.length()){
            while(j < word2.length()){
                sb.append(word2.charAt(j)); 
                j++;
            }
        }
        
        return sb.toString();
    }
}
