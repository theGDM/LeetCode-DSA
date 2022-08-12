class Solution{
    static long minTime(int[] arr,int n,int k){
       long lta = Long.MIN_VALUE; //lowest time allowed
       long hta = 0; //highest time allowed
       
       for(int num : arr){
           lta = Math.max(lta, num);
           hta += num;
       }
       
       while(lta < hta){
           long allwedTime = lta + (hta - lta) / 2;
           
           int noOfPainters = 1;
           int timeTaken = 0;
           
           for(int num : arr){
               if(timeTaken + num <= allwedTime){
                   timeTaken += num;
               }else{
                   timeTaken = num;
                   noOfPainters++; 
               }
           }
           
           if(noOfPainters > k){ //no of painters zyada ho gaye, matlab allowed time kafi kam kardiya,
               lta = allwedTime + 1; //isiliye badaho use
           }else{
               hta = allwedTime;
           }
       }
       
       return lta;
    }
}
