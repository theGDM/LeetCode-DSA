class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while(i < firstList.length && j < secondList.length){
            int[] interval1 = firstList[i];
            int[] interval2 = secondList[j];
            
            int a = Math.max(interval1[0], interval2[0]);
            int b = Math.min(interval1[1], interval2[1]);
            
            if(a <= b){
                res.add(new int[]{a, b});
            }
            
            // Now no need of this part
            // if(i + 1 < firstList.length){
            //     if(interval2[1] == firstList[i + 1][0]){
            //         res.add(new int[]{interval2[1], interval2[1]});
            //     }
            // }
            
            //jiska chhota hai, us pointer ko badha do
            if(interval1[1] < interval2[1]){
                i++;
            }else{
                j++;
            }
        }
        
        return res.toArray(new int[res.size()][2]);
    }
}
