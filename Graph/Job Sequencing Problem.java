class Solution{
    //Function to find the maximum profit and the number of jobs done.
    class jobPair implements Comparable<jobPair>{
        int d;
        int p;
        
        jobPair(int d, int p){
            this.d = d;
            this.p = p;
        }
        
        public int compareTo(jobPair o){
            return o.p - this.p;
        }
    }
    
    int[] parent; //parent array
    int[] JobScheduling(Job arr[], int n){
        int maxDeadline = Integer.MIN_VALUE;
        //finding the maxDeadline of compleating a job
        for(int i = 0; i < arr.length; ++i){
            Job j = arr[i];
            maxDeadline = Math.max(maxDeadline, j.deadline);
        }
        //making the parent array
        parent = new int[maxDeadline + 1];
        for(int i = 0; i < parent.length; ++i){
            parent[i] = i;
        }
        
        //making priority queue, so that we get job having profit more first
        PriorityQueue<jobPair> pq = new PriorityQueue<>();
        for(int i = 0; i < arr.length; ++i){
            pq.add(new jobPair(arr[i].deadline, arr[i].profit));
        }
        
        int count = 0; //job completed
        int profit = 0; //if job completed, we get profit of that respective job
        while(pq.size() > 0){
            jobPair jp = pq.remove(); //extract the job having profit(high), in decreasing order
            
            int dline = jp.d; //getting its deadline period
            int dlead = find(dline); //finding the lead of deadline
            
            if(dlead > 0){
               count++; 
               
               profit += jp.p;
               parent[dlead] = find(dlead - 1); 
            }
        }
        
        // while(pq.size() > 0){
        //   System.out.print(pq.remove().p + " ");
        // }
        
        return new int[]{count, profit};
    }
    
    int find(int x){
        if(parent[x] == x){
            return x;
        }else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    } 
}
*/
