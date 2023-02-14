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

//TC : O((m + n) + log(m.n))
//to compare the two concatenations of length (m + n), it takes O(m + n) time.
//We calculate the GCD using binary Euclidean algorithm, it takes O(log(m.n))
class Solution { 
    public String gcdOfStrings(String str1, String str2) {
        if((str1 + str2).equals(str2 + str1) == false){
            return "";
        }
        
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }
    
    //TC : O(log(m.n))
    public int gcd(int x, int y){
        if(y == 0){
            return x;
        }else{
            return gcd(y, x % y);
        }
    }
}
