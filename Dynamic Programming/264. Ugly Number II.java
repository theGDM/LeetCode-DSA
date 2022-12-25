//naive approach
//SC : O(3 * n)
//TC : O(nlogn)
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1l);
        
        int count = 0;
        while(count != n - 1){ //(n - 1)th time 
            long rem = pq.remove();
            count++;
            
            while(pq.size() != 0 && pq.peek() == rem) pq.remove(); //remove the duplicates if present
            
            pq.add(rem * 2);
            pq.add(rem * 3);
            pq.add(rem * 5);
        }
        
        return pq.remove().intValue(); //nth time we will get nth ugly number
    }
    
}

class Solution {
    //TC : O(N);
    //SC : O(N);
    public int nthUglyNumber(int n) {
        //pointers pointing to indices not values
        int p2 = 1, p3 = 1, p5 = 1;
        int[] dp = new int[n + 1];
        dp[1] = 1; //first ugly number is 1
        
        for(int i = 2; i <= n; ++i){
            int p2Val = dp[p2] * 2;
            int p3Val = dp[p3] * 3;
            int p5Val = dp[p5] * 5;
            
            int currentUglyNumber = Math.min(p2Val, Math.min(p3Val, p5Val));
            //move the pointer(s) that produced the currentUglyNumber
            //so we don't consider that value again
            if(currentUglyNumber == p2Val) p2++;
            if(currentUglyNumber == p3Val) p3++;
            if(currentUglyNumber == p5Val) p5++;
            dp[i] = currentUglyNumber;
        }
        
        return dp[n];
    }  
}

//SC : O(3 * n)
//TC : O(nlogn)
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> visited = new HashSet<>();
        pq.add(1l);
        
        int count = 0;
        while(pq.size() > 0){ 
            long rem = pq.remove();
            if(visited.contains(rem)) continue;
            
            count++;
            if(count == n) return (int)rem; //nth time we will get nth ugly number
            
            visited.add(rem); //mark visited
            pq.add(rem * 2);
            pq.add(rem * 3);
            pq.add(rem * 5);
        }
        
        return -1; 
    }  
}
