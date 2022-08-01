// Given an array, find maximum sum of smallest and second smallest elements chosen from all possible sub-arrays. More formally, if we write all (nC2) 
// sub-arrays of array of size >=2 and find the sum of smallest and second smallest, then our answer will be maximum sum among them.
 
// Example 1:
// Input : arr[] = [4, 3, 1, 5, 6]
// Output : 11
// Subarrays with smallest and 
// second smallest are,
// [4, 3]        
// smallest = 3    second smallest = 4
// [4, 3, 1]    
// smallest = 1    second smallest = 3
// [4, 3, 1, 5]    
// smallest = 1    second smallest = 3
// [4, 3, 1, 5, 6]    
// smallest = 1    second smallest = 3
// [3, 1]         
// smallest = 1    second smallest = 3
// [3, 1, 5]     
// smallest = 1    second smallest = 3
// [3, 1, 5, 6]    
// smallest = 1    second smallest = 3
// [1, 5]        
// smallest = 1    second smallest = 5
// [1, 5, 6]    
// smallest = 1    second smallest = 5
// [5, 6]         
// smallest = 5    second smallest = 6
// Maximum sum among all 
// above choices is, 5 + 6 = 11
 
// Example 2:
// Input : arr[] = {5, 4, 3, 1, 6} 
// Output : 9
 

// Your Task:  
// You don't need to read input or print anything. Your task is to complete the function pairWithMaxSum() which takes the array Arr[] and its size N as inputs and returns the maximum sum of smallest and second smallest elements chosen from all possible subarrays.

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(1)

//Matlab, second smallest aur smallest ke beech me koi aur nahi ho sakta...
//kisi bhi, array, ke subarrays, ke smallest aur second smallest always continuous hoge, koi aur element inke beech me nahi hoga
//if x, y answer hai, to yadi unke beech me
koi aur element aa jaye, iska matlab, x, y ab answer nahi ho sakte! So maximum sum of smallest and second smallest element
//hmesha continue honge!
class Solution {
    public static long pairWithMaxSum(long arr[], long N){
        // Your code goes here
        long max = 0;
        for(int i = 0; i < N - 1; ++i){
            if(arr[i] + arr[i + 1] > max){
                max = arr[i] + arr[i + 1];
            }
        }
        
        return max;
    }
}
