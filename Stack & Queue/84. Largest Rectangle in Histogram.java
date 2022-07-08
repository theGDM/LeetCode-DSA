//find next smaller element to the left and then, next smaller element to the right
class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nser = nextSmallerElementToRigth(heights);
        // for(int i = 0; i < nser.length; ++i){
        //     System.out.print(nser[i] + " ");
        // }
        // System.out.println();
        
        int[] nsel = nextSmallerElementToLeft(heights);
        // for(int i = 0; i < nsel.length; ++i){
        //     System.out.print(nsel[i] + " ");
        // }
        // System.out.println();
        
        int maxArea = 0;
        for(int i = 0; i < heights.length; ++i){
            int width = nser[i] - nsel[i] - 1;
            int height = heights[i];
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
    
    public int[] nextSmallerElementToRigth(int[] heights){
        int[] nser = new int[heights.length];
        Stack<Integer> stk = new Stack<>();
        for(int i = heights.length - 1; i >= 0; --i){
            while(stk.size() > 0 && heights[i] <= heights[stk.peek()]){
                stk.pop();
            }
            
            if(stk.size() > 0){
                nser[i] = stk.peek();
            }else{
                nser[i] = heights.length;;
            }
            
            //push yourself to find your own nge to the right
            stk.push(i);
        }
        
        return nser;
    }
    
    public int[] nextSmallerElementToLeft(int[] heights){
        int[] nsel = new int[heights.length];
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < heights.length; ++i){
            while(stk.size() > 0 && heights[i] <= heights[stk.peek()]){
                stk.pop();
            }
            
            if(stk.size() > 0){
                nsel[i] = stk.peek();
            }else{
                nsel[i] = -1;
            }
            
            //push yourself to find your own nge to the right
            stk.push(i);
        }
        
        return nsel;
    }
}
