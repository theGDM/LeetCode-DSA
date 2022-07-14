//Concept of next permutation is used, as question is demanding, that we need to generate a number 
//just greater that the n, and which has exactly the same digit as n
class Solution {
    public int nextGreaterElement(int n) {    
        String s = Integer.toString(n);
        int[] a = new int[s.length()];
        for(int i = 0; i < a.length; ++i){
            a[i] = s.charAt(i) - '0';
        }
        
        int idx1 = -1, idx2 = -1;
        for(int i = a.length - 1; i >= 0; --i){
            if(i != a.length - 1 && a[i] < a[i + 1]){
                idx1 = i;
                break;
            }
        }
        
        //edge case
        if(idx1 == -1){ //as this number itself is the last permuation, the next permutation the very
            return -1;  //first guy..
        }
        
        //find the element just greater than the a[idx1]
        for(int i = a.length - 1; i >= 0; --i){
            if(a[i] > a[idx1]){
                idx2 = i;
                break;
            }
        }
        
        //swap values at the both index
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
        
        //reverse all the element beyond idx1 + 1;
        reverse(idx1 + 1, a.length - 1, a);
        
        long res = 0;
        int mul = (int)Math.pow(10, a.length - 1);
        for(int i = 0; i < a.length; ++i){
            res += (long)a[i] * mul;
            mul /= 10;
        }
        
        return (res <= Integer.MAX_VALUE) ? (int) res : -1;
    }
    
    public void swap(int i, int j, int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
        
    
    public void reverse(int left, int right, int[] a){
        while(left < right){
            swap(left, right, a);
            left++;
            right--;
        }
    }
} 
