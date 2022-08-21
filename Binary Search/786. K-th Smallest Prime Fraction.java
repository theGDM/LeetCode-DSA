class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double lo = 0.0;
        double hi = 1.0;
        
        int reqd = k;
        
        while(lo < hi){
            double mid = lo + (hi - lo) / 2;
            int p = 0;
            int q = 1;
            
            int actual = 0;
            int j = 0;
            for(int i = 0; i < arr.length; ++i){
                while(j < arr.length && arr[i] > mid * arr[j]){ //arr[i] / arr[j] > mid
                    j++;
                }
                
                if(j == arr.length) break;
                
                actual += arr.length - j;
                
                if(arr[i] * q > p * arr[j]){ //arr[i] / arr[j] > p * q
                    p = arr[i]; //jo sabse closest, pair hai usko answer banao
                    q = arr[j];
                }
            }
            
            if(actual < reqd){
                lo = mid;
            }else if(actual > reqd){
                hi = mid;
            }else{
                return new int[]{p, q};
            }
        }
        
        return null;
    }
}

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double lo = 0.0;
        double hi = 1.0;
        
        int reqd = k;
        
        while(lo < hi){
            double mid = lo + (hi - lo) / 2;
            int p = 0;
            int q = 1;
            
            int actual = 0;
            int j = 0;
            for(int i = 0; i < arr.length; ++i){
                while(j < arr.length && arr[i] * 1.0 / arr[j] > mid){ //arr[i] / arr[j] > mid
                    j++;
                }
                
                if(j == arr.length) break;
                
                actual += arr.length - j;
                
                if(arr[i] * 1.0 / arr[j] > p * 1.0 / q){ //arr[i] / arr[j] > p * q
                    p = arr[i]; //jo sabse closest, pair hai usko answer banao
                    q = arr[j];
                }
            }
            
            if(actual < reqd){
                lo = mid;
            }else if(actual > reqd){
                hi = mid;
            }else{
                return new int[]{p, q};
            }
        }
        
        return null;
    }
}
