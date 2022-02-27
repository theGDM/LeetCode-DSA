// Problem Statement
// You have been given a queue of ‘N’ distinct integers. For a given queue, you need to reverse all the elements in it.
// Note:
// You need to reverse the string in O(N) time complexity.
// Input Format:
// The first line contains a single integer ‘T’ representing the number of test cases. 

// The first line of each test case will contain an integer ‘N’ where ‘N’ is the size of the queue.

// The last line of each test case will contain the ‘N’ elements of the queue.
// Output Format:
// For each test case, print the elements of the reversed queue.

// Output for every test case will be printed in a separate line.
// Note:
// You don’t need to print anything; It has already been taken care of. You just need to complete the function.
// Constraints:
// 1 <= T <= 50
// 1 <= N <= 10^4
// 0 <= Q[i] <= 10^5

// Where Q[i] denotes the value ith element of the input queue.

// Time Limit: 1 sec
// Sample Input 1:
// 2
// 3
// 2 3 1
// 5
// 6 8 9 2 3   
// Sample Output 1:
// 1 3 2
// 3 2 9 8 6
// Explanation For Sample Input 1:
// In the first test case, after reversing the queue, the resultant elements of the reversed queue will be 1 3 2.

// In the second test case, after reversing the queue, the resultant elements of the reversed queue will be 3 2 9 8 6.

public class Solution {
    public static void reverse(Queue < Integer > q) {
        if(q.size() == 0){ //base case
            return;
        }
        
        int val = q.remove(); //curr element remove -> o(1) work in preorder
        reverse(q); //faith call
        q.add(val); //add in postorder
    }
}
