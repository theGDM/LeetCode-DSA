class Solution {
    public int thirdMax(int[] nums) {
        Integer fm = null;
        Integer sm = null;
        Integer tm = null;
        
        //this code will help to find unique , fm, sm, tm
        for(Integer n : nums){
            if(n.equals(fm) || n.equals(sm) || n.equals(tm)) continue;
            
            if(fm == null || n > fm){
                tm = sm;
                sm = fm;
                fm = n;
            }else if(sm == null || n > sm){
                tm = sm;
                sm = n;
            }else if(tm == null || n > tm){
                tm = n;
            }
        }
        
        return tm == null ? fm : tm;
    }
}
