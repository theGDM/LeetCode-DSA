class MyHashSet {
    LinkedList<Integer>[] buckets;
    int size;
    public MyHashSet() {
        initBuckets(4);
        size = 0;
    }
    
    private void initBuckets(int N){
        buckets = new LinkedList[N];
        for(int bi = 0; bi < N; ++bi){
            buckets[bi] = new LinkedList<>();
        }
    }
    
    public int hashFn(int key){
        Integer k = key; //it will avoid the problem of int can not be dereferenced
        int hc = k.hashCode(); //getting the hashcode of key(it could return +ve or -ve value)
        int bi = Math.abs(hc) % buckets.length;
        return bi;
    }
    
    
    public int getDataIndexFromBucket(int key, int bi){
        int di = 0;
        for(int data : buckets[bi]){
            if(data == key){
                return di;
            }
            di++;
        }
        
        return -1;
    }
    
    public void add(int key) {
        int bi = hashFn(key);
        int di = getDataIndexFromBucket(key, bi);
        
        if(di == -1){
            buckets[bi].add(key);
            size++;
        } //if already present, need not to insert again
        
        double lamda = size * 1.0 / buckets.length; //loading factor
        if(lamda > 2.0){
            reHash(); //do rehashing
        }
    }
    
    public void reHash(){
        LinkedList<Integer>[] ob = buckets; //old buckets
        initBuckets(ob.length * 2);
        
        for(int bi = 0; bi < ob.length; ++bi){
            for(int key : ob[bi]){
                add(key);
            }
        }
    }
    
    public void remove(int key) {
        int bi = hashFn(key);
        int di = getDataIndexFromBucket(key, bi);
        
        if(di != -1){
            buckets[bi].remove(di);
            size--;
        }
    }
    
    public boolean contains(int key) {
        int bi = hashFn(key);
        int di = getDataIndexFromBucket(key, bi);
        
        if(di != -1){
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
