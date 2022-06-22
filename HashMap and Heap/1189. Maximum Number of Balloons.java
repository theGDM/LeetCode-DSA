class Solution {
    //O(n)
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < text.length(); ++i){
            char ch = text.charAt(i);
            if(ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n'){
                if(hm.containsKey(ch)){
                    hm.put(ch, hm.get(ch) + 1);
                }else{
                    hm.put(ch, 1);
                }
            }
        }
        
        //edge case //means all character is not found in the text string
        //in order to make a ballon word we have atleast one count for b, a, n 
        //and atleast two count for l, o
        if(hm.size() < 5) return 0;
        
        //we are dividing the occurrence of o and l by two beacuse the min count of both these two must 
        //be atleast 2 to form balloon word
        int min = Integer.MAX_VALUE;
        for(char key : hm.keySet()){
            if(key == 'l' || key == 'o'){
                min = Math.min(min, hm.get(key) / 2);
            }else{
                min = Math.min(min, hm.get(key)); 
            }
        }
        
        return min;
    }
}
