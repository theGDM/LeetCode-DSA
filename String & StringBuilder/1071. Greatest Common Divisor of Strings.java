class Solution { 
    public String gcdOfStrings(String str1, String str2) {
        String s1 = ""; //s1 is string of smaller size
        String s2 = ""; //s2 is string of larger size
        
        if(str1.length() <= str2.length()){
            s1 = str1;
            s2 = str2;
        }else{
            s1 = str2;
            s2 = str1;
        }
        
        return helper(s1, s2);
    }
    
    public String helper(String str1, String str2){
        if(str1 == ""){
            return str2;
        }
        
        int len = str1.length();
        if(str1.equals(str2.substring(0, len))){
            String rem = str2.substring(len); //remainder, after dividing
            if(rem.length() < str1.length()){
                return helper(rem, str1);
            }else{
                return helper(str1, rem);
            }
        }else{
            return "";
        }
    }
}
