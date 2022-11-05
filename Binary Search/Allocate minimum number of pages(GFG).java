class Solution {
    //Function to find minimum number of pages.
    public static int findPages(int[] A,int N,int M){
        if(N < M){
            return -1;
        }
        
        int minPagesAllowed = Integer.MIN_VALUE; //lowest allowed pages
        int maxPagesAllowed = 0; //higehst allowed pages
        
        for(int pages : A){
            maxPagesAllowed += pages;
            minPagesAllowed = Math.max(minPagesAllowed, pages);
        }
        
        while(minPagesAllowed < maxPagesAllowed){
            int allot = minPagesAllowed + (maxPagesAllowed - minPagesAllowed) / 2;
            
            int numOfStudents = 1;
            int currenSumOfPages = 0;
            
            for(int pages : A){
                if(currenSumOfPages + pages <= allot){
                    currenSumOfPages += pages;
                }else{
                    currenSumOfPages = pages;
                    numOfStudents++;
                }
            }
            
            if(numOfStudents > M){
                minPagesAllowed  = allot + 1;
            }else{
                maxPagesAllowed = allot;
            }
        }
        
        return minPagesAllowed;
    }
};
