class MyHashMap {
    
    private class HMNode{
        int key;
        int value;
        
        HMNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    //Array of linkedlist, having HMNode as value, of linkedlist
    private LinkedList<HMNode>[] buckets;
    private int size;
    
    public MyHashMap() {
        initBuckets(4);
        size = 0;
    }
    
    private void initBuckets(int N){
        buckets = new LinkedList[N];
        for(int bi = 0; bi < N; ++bi){
            buckets[bi] = new LinkedList<>();
        }
    }
    
    private int hashFn(int key){
        Integer k = key; //it will avoid the problem of int can not be dereferenced
        int hc = k.hashCode(); //getting the hashcode of key(it could return +ve or -ve value)
        int bi = Math.abs(hc) % buckets.length;
        return bi;
    }
    
    public int getDataIndexInBucket(int key, int bi){
        int di = 0;
        for(HMNode node : buckets[bi]){
            if(node.key == key){
                return di;
            }
            
            di++;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        int bi = hashFn(key);
        int di = getDataIndexInBucket(key, bi);
        
        if(di == -1){
            HMNode node = new HMNode(key, value);
            buckets[bi].add(node);
            size++;
        }else{
            HMNode node = buckets[bi].get(di);
            node.value = value;
        }
        
        double lambda = size * 1.0 / buckets.length; //check for loading factor
        if(lambda > 2.0){
            rehash();
        }
    }
    
    public void rehash(){
        LinkedList<HMNode>[] ob = buckets; //old buckets
        initBuckets(ob.length * 2);
        
        for(int bi = 0; bi < ob.length; ++bi){
            for(HMNode node : ob[bi]){
                put(node.key, node.value);
            }
        }
    }
    
    public int get(int key) {
        int bi = hashFn(key);
        int di = getDataIndexInBucket(key, bi);
        
        if(di != -1){ //if di is not -1, it means that key is found, return value corresponding to it
            return buckets[bi].get(di).value;
        }else{
            return -1;
        } 
    }
    
    public void remove(int key) {
        int bi = hashFn(key);
        int di = getDataIndexInBucket(key, bi);
        
        if(di != -1){ //if di is not -1, it means that key is found, remove it
            size--;
            buckets[bi].remove(di);
            return;
        }else{
            return;
        } 
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
