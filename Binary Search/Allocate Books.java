public class Solution {
    public int books(ArrayList<Integer> A, int B) {
        if(A.size() < B){
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
            
            if(numOfStudents > B){
                minPagesAllowed  = allot + 1;
            }else{
                maxPagesAllowed = allot;
            }
        }
        
        return minPagesAllowed;
    }
}
