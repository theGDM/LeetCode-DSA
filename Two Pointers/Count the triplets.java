//User function Template for Java
//normal loop + two sum
class Solution {
    int countTriplet(int arr[], int n) {
        Arrays.sort(arr);
        int count = 0;
        for(int i = arr.length - 1; i >= 2; --i){ //back se loop lagao,,if aange se chalayenge, to koi triplet na milage
            int target = arr[i];
            
            int left = 0;
            int right = i - 1;
            while(left < right){
                int sum = arr[left] + arr[right];
                
                if(sum < target){
                    left++;
                }else if(sum > target){
                    right--;
                }else{
                    count++;
                    left++;
                    right--;
                }
            }
        }
        
        return count;
    }
}
