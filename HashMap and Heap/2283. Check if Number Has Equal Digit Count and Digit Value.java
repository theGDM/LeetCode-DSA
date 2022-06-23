class Solution {
    public boolean digitCount(String num) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        //first we are making the hashmap for the num and its digits
        for(int i = 0;i < num.length(); ++i){
            int ch = num.charAt(i) - '0';
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch) + 1);
            }else{
                hm.put(ch, 1);
            }
        }
        
        //Now those numberse between [0 - num.length -1], do not occcur in the num, we will put there frequency to 0
        for(int i = 0; i < num.length(); ++i){
            if(hm.containsKey(i) == false){
                hm.put(i, 0);
            }
        }
        
        //Now make the string for the occurence of ith index in the num
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < num.length(); ++i){
           res.append(hm.get(i)); 
        }
        
        // System.out.println(res);
        return num.equals(res.toString());
    }
}
