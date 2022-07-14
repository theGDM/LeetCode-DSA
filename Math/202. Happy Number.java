//myway
class Solution {
    public boolean isHappy(int n) {
        int res = 0;
        while(n > 0){
            int rem = n % 10;
            res += rem * rem;
            n /= 10;

            if(n == 0){
                if(res == 1 || res == 7) return true;
                else if(res > 1 && res < 10) return false;
                else{
                    n = res;
                    res = 0;
                }
            }
        }

        return true;
    }
}

//using hashset
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        int squareSum,remain;

        while(inLoop.add(n)) {
            squareSum = 0;
            while(n > 0) {
                remain = n % 10;
                squareSum += remain * remain;
                n /= 10;
            }

            if(squareSum == 1)
                return true;
            else
                n = squareSum;

        }

        return false;

    }
}
