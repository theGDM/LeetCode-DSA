class Solution {
    public int reachNumber(int target) {
        int step = 1;
        target = Math.abs(target);
        while(true){
            int maxPosition = step * (step + 1) / 2;
            // System.out.println(target + " " + maxPosition);
            if(target <= maxPosition){
                if(target % 2 == maxPosition % 2){
                    return step;
                }
            }
            
            step++;
        }
    }
}
