//O(N) to build a map + O(NlogN) to put in PQ + O(KlogK) to build a result
class Solution {
    public class Pair implements Comparable<Pair>{
        String word;
        int freq;
        
        Pair(String word, int freq){
            this.word = word;
            this.freq = freq;
        }
        
        public int compareTo(Pair O){
            if(this.freq != O.freq){
                return O.freq - this.freq;
            }else{
                return this.word.compareTo(O.word); //if freq same sort in lexcographically order
            }
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        if(words == null || words.length == 0) {
            return new ArrayList<>();
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words){ //O(n)
            map.put(word , map.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(String key : map.keySet()){ // nlog(n) , when all the words are different, size of hasmap will be n
            pq.add(new Pair(key, map.get(key)));
        }
        
        List<String> res = new ArrayList<>();
        while(k-- > 0){
            Pair p = pq.remove(); //klogk
            res.add(p.word);
        }
        
        return res;
    }
}
