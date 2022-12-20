class RandomizedSet {
    HashMap<Integer, Integer> valueToIdx;
    ArrayList<Integer> list;
    public RandomizedSet() {
        valueToIdx = new HashMap<>();
        list = new ArrayList<>();
    }
    
    //O(1)
    public boolean insert(int val) {
        if(valueToIdx.containsKey(val) == true) return false;
        
        list.add(val);
        valueToIdx.put(val, list.size() - 1);
        return true;
    }
    
    //O(n)
    public boolean remove(int val) {
        if(valueToIdx.containsKey(val) == false) return false;
        
        int idx = valueToIdx.get(val); //at this index the val is present in the list
        
        //Now decrease the index of all the values in map, after the val's index, as after deleting that
        //value from list, shifting will happen
        for(int i = idx + 1; i < list.size(); ++i){
            int listItem = list.get(i);
            valueToIdx.put(listItem, valueToIdx.get(listItem) - 1);
        }
        
        list.remove(idx);
        valueToIdx.remove(val);
        return true;
    }
    
    //TC : O(1)
    public int getRandom() {
        int min = 0;
        int max = list.size();
        int ind = (int)(Math.random() * (max - min) + min);
        return list.get(ind);
    }
    
    //O(1)
    public void swap(int i, int j, ArrayList<Integer> list){
        int ithValue = list.get(i);
        int jthValue = list.get(j);
        
        list.set(i, jthValue);
        list.set(j, ithValue);
    }
}

//FollowUp
class RandomizedSet {
    HashMap<Integer, Integer> valueToIdx;
    ArrayList<Integer> list;
    public RandomizedSet() {
        valueToIdx = new HashMap<>();
        list = new ArrayList<>();
    }
    
    //O(1)
    public boolean insert(int val) {
        if(valueToIdx.containsKey(val) == true) return false;
        
        list.add(val);
        valueToIdx.put(val, list.size() - 1);
        return true;
    }
    
    //O(1)
    public boolean remove(int val) {
        if(valueToIdx.containsKey(val) == false) return false;
        
        int idx = valueToIdx.get(val); //at this index the val is present in the list
        //as we have to delete the val from list in O(1) time so we need to, move it to the last index
        swap(idx, list.size() - 1, list);
        int swappedWith = list.get(idx);
        valueToIdx.put(swappedWith, idx);
        //remove that item from the list and map now
        list.remove(list.size() - 1);
        valueToIdx.remove(val);
        return true;
    }
    
    //TC : O(1)
    public int getRandom() {
        int min = 0;
        int max = list.size();
        int ind = (int)(Math.random() * (max - min) + min);
        return list.get(ind);
    }
    
    //O(1)
    public void swap(int i, int j, ArrayList<Integer> list){
        int ithValue = list.get(i);
        int jthValue = list.get(j);
        
        list.set(i, jthValue);
        list.set(j, ithValue);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
