//TC : O(nlog(n))
//SC : O(n)
class Solution {
    //custom comparator
    private class LargestNumberComparator implements Comparator<String>{
        @Override
        public int compare(String a, String b){
            String case1 = a + b;
            String case2 = b + a;
            return case2.compareTo(case1);
        }
    }
    
    public String largestNumber(int[] nums) {
        String[] sarr = new String[nums.length];
        
        for(int i = 0; i < nums.length; ++i){
            sarr[i] = nums[i] + "";
        }
        
        // Sort strings according to custom comparator.
        Arrays.sort(sarr, new LargestNumberComparator());
        
        // If, after being sorted, the largest number is `0`, the entire number is zero.
        if(sarr[0].equals("0")) {
            return "0";
        }
        
        StringBuilder res = new StringBuilder();
        for(String str : sarr){
            res.append(str);
        }
        
        return res.toString();    
    }
}
