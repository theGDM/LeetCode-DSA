public class Solution {
    /**
     * @param length: the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */

    //TC : O(updates.length)
    //SC : O(length) 
    public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        int[] parr = new int[length];

        for(int[] update : updates){
            int st = update[0];
            int en = update[1];
            int d = update[2];

            parr[st] += d; //add +d at stating index
            if(en + 1 < parr.length){
                parr[en + 1] += -d; //add -d at ending index + 1
            }
        }

        for(int i = 1; i < parr.length; ++i){
            parr[i] = parr[i - 1] + parr[i];
        }

        return parr;
    }
}
