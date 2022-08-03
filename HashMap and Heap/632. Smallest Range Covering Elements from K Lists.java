//TC : Klog(k) + Nlog(k) ~ Nlog(k) ~ nklog(k), where N = nk
//here N -> Total number of elements in the list
//if n is the average size of a list, then total elements in k list = n * k
//In worst we may, process all the elements in the list, while maintaining the size of pq always k
//SC : log(k)

class Solution {
    public class Pair implements Comparable<Pair>{
        int data;
        int listIdx; //list index
        int dataIdx; //data index
        
        Pair(int data, int dataIdx, int listIdx){
            this.data = data;
            this.dataIdx = dataIdx;
            this.listIdx = listIdx;
        }
        
        public int compareTo(Pair o){
            return this.data - o.data;
        }
    }
    
    //dalte hue, max change ho raha hai, nikalte hue range change ho rahi hai
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); ++i){
            max = Math.max(max, nums.get(i).get(0));
            pq.add(new Pair(nums.get(i).get(0), 0, i));
        }
        
        int st = 0; //starting element of range
        int en = 0; //ending element of range
        int range = Integer.MAX_VALUE; //intially range is set to infinity
        
        while(true){
            Pair p = pq.remove();
            
            int currEnd = p.data;
            int currRange = max - currEnd; //current range
            
            if(currRange < range){ //if current range is more tighter, update st, and en
                st = max; //update start
                en = currEnd; //update end
                range = currRange;
            }
            
            //check for breaking condition
            if(p.dataIdx + 1 >= nums.get(p.listIdx).size()) break;
            pq.add(new Pair(nums.get(p.listIdx).get(p.dataIdx + 1), p.dataIdx + 1, p.listIdx));
            
            //update max while adding into pq..
            if(nums.get(p.listIdx).get(p.dataIdx + 1) > max){
                max = nums.get(p.listIdx).get(p.dataIdx + 1); 
            }
            
        }
        
        return new int[]{st, en};
    }
}
