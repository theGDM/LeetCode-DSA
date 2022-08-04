//Using map..TC : O(n)
//SC : O(n)
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        
        
        int st = 0;
        int en = 0;
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(map.get(ch) > en){
                en = map.get(ch);
            }else if(i == en) {
                int resLen = en - st + 1;
                res.add(resLen);
                en = st = i + 1;
            }
        }
        
        return res;
    }
}


//Using Array..TC : O(n)
//SC : O(n)
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[26];
        Arrays.fill(map, -1);
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            map[ch - 'a'] = i;
        }
        
        
        int st = 0;
        int en = 0;
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            en = Math.max(en, map[ch - 'a']);
            
            if(i == en) {
                int resLen = en - st + 1;
                res.add(resLen);
                en = st = i + 1;
            }
        }
        
        return res;
    }
}
