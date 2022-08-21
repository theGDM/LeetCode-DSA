class Solution{ 
    ArrayList<Integer> search(String pat, String text){
        int[] lps = getLPS(text); //O(n)
        
        int i = 0;
        int j = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while(i < text.length()){ //O(n)
            if(text.charAt(i) == pat.charAt(j)){
                i++;
                j++;
                
                if(j == pat.length()){
                    res.add(i - pat.length() + 1);
                    j = lps[j - 1]; //apne pichele wale element ke lps ke barabar jao..
                }
            }else if(j == 0){
                i++;
            }else{
                j = lps[j - 1];
            }
        }
        
        return res;
    }
    
    public int[] getLPS(String text){
        int i = 1;
        int len = 0;
        int[] lps = new int[text.length()];
        
        while(i < text.length()){
            if(text.charAt(i) == text.charAt(len)){
                lps[i] = len + 1;
                len++;
                i++;
            }else if(len == 0){
                lps[i] = 0;
                len = 0;
                i++;
            }else{
                len = lps[len - 1];
            }
        }
        
        return lps;
    }
}
