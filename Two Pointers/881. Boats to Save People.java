//two pointer concept
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        int ans = 0;
        while(left < right){
            if(people[left] + people[right] <= limit){
                ans++;
                left++;
                right--;
            }else{
                ans++;
                right--;
            }
        }
        
        //if left > right, means no person left
        //if left == right, means still one people, so one more boat for him..
        if(left == right) ans += 1;
        return ans;
    }
}

//2nd approach
//output : [5,1,4,2] , 6 //test case fail
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int boat = 0;
        int sum = 0;
        for(int i = 0;i < people.length; ++i){
            if(sum + people[i] > limit){
                boat++;
                sum = 0;
            }
            sum += people[i];
        }
        
        boat++;
        return boat;
    }
}
