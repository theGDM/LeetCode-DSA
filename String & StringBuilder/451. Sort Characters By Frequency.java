//NLOGN
class Solution {
    public class Pair implements Comparable<Pair>{
        char ch;
        int freq;
        
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
        
        public int compareTo(Pair O){
            return O.freq - this.freq;
        }
    }
    
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); ++i){ //O(n)
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(char ch : map.keySet()){//nlogn
            pq.add(new Pair(ch, map.get(ch)));
        }
        
        StringBuilder ans = new StringBuilder();
        while(pq.size() > 0){ //nlog(n)
            Pair p = pq.remove();
            for(int i = 1; i <= map.get(p.ch); ++i){
                ans.append(p.ch);
            }
        }
        
        return ans.toString();
    }
}


//TC : O(N)
//Using Bucket sort technique
public class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        //creating hashmap O(N)
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        } 
        
        //putting keys in buckets O(N)
        List<Character>[] buckets = new List[s.length() + 1]; //because max frequency of any char is s.length()
        for(char ch : map.keySet()){
            int freq = map.get(ch);
            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(ch);
        }
        
        //making the result
        StringBuilder res = new StringBuilder();
        for(int pos = buckets.length - 1; pos >= 0; --pos){
            if(buckets[pos] != null){
                for(char key : buckets[pos]){
                    for(int i = 1; i <= pos; ++i){
                        res.append(key);
                    }
                }
            }
        }
        
        return res.toString();
    }
}
