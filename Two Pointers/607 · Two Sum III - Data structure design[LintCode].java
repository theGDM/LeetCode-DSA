//When find comes, then only sort, otherwise time complexity will we poor, if we sort after every add,
//even if we don't have task of find later..
public class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */
    ArrayList<Integer> data;
    boolean isSorted;

    public TwoSum(){
        data = new ArrayList<>();
        isSorted = true;
    }

    //addLast -> O(1)
    public void add(int number) {
        data.add(number);
        isSorted = false;
    }

    //find pair -> O(nlogn)
    public boolean find(int value) {
        if(isSorted == false){
            Collections.sort(data);
        }

        int left = 0; int right = data.size() - 1;

        while(left < right){
            int sum = data.get(left) + data.get(right);
            if(sum == value) return true;
            else if(sum > value) right--;
            else left++;
        }

        return false;
    }
}

//When find comes, then only sort, otherwise time complexity will we poor, if we sort after every add,
//even if we don't have task of find later..
public class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */
    HashMap<Integer, Integer> map;
    
    public TwoSum(){
        map = new HashMap<>();
    }

    //addLast -> O(1)
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    //find pair -> O(n)
    public boolean find(int value) {
        for(int key : map.keySet()){
            int comp = value - key;
            if(comp == key){
                if(map.get(comp) >= 2) return true;
            }else if(map.containsKey(comp) == true){
                return true;
            }
        }

        return false;
    }
}
