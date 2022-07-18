class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int idx = 0;
        int steps = 0;
        int cCap = capacity;
        while(idx < plants.length){
            if(plants[idx] <= cCap){
                steps += 1; //1step for reaching the plant
                cCap -= plants[idx]; //decrease the capacity after watering the plant
            }else{
                cCap = capacity;
                steps += idx + (idx + 1); //going to fill + coming back to the same plant
                cCap -= plants[idx]; //decrease the capacity after watering the plant
            }
            
            idx++;
        }
        
        return steps;
    }
}
