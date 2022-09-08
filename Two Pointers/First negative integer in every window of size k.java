class Compute {
    //TC : O(n)
    public long[] printFirstNegativeInteger(long A[], int N, int K){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        long[] res = new long[N - K + 1];
        
        for(int i = 0; i < K; ++i){
            if(A[i] < 0){
                queue.addLast(i);
            }
        }
        
        int idx = 0;
        res[idx++] = queue.size() != 0 ? A[queue.getFirst()] : 0;
        
        for(int i = K; i < N; ++i){
            int incIdx = i;
            int excIdx = i - K;
            
            if(A[incIdx] < 0){ //include the element in the queue only if it is -ve;
                queue.addLast(incIdx);
            }
            
            if(queue.size() > 0 && excIdx == queue.getFirst()){ //remove, when excIdx is present in queue
                queue.removeFirst();
            }
            
            res[idx++] = queue.size() != 0 ? A[queue.getFirst()] : 0;
        }
         
        return res;
    }
}

class Compute {
    //Tc : O(n)
    public long[] printFirstNegativeInteger(long A[], int N, int K){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        long[] res = new long[N - K + 1];
        
        for(int i = 0; i < K; ++i){
            if(A[i] < 0){
                queue.addLast(i);
            }
        }
        
        int idx = 0;
        res[idx++] = queue.size() != 0 ? A[queue.getFirst()] : 0;
        
        for(int i = K; i < N; ++i){
            if(queue.size() > 0 && queue.getFirst() == i - K){ //remove,  
                queue.removeFirst();
            }
            
            if(A[i] < 0){ 
                queue.addLast(i);
            }
        
            res[idx++] = queue.size() != 0 ? A[queue.getFirst()] : 0;
        }
         
        return res;
    }
}
