//Using arraylist
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        
        int idx = num.length - 1;
        int carry = 0;
        while(idx >= 0 || k > 0 || carry != 0){
            int d1 = idx >= 0 ? num[idx] : 0;
            int d2 = k % 10;
            
            int sum = (d1 + d2 + carry) % 10;
            carry = (d1 + d2 + carry) / 10;
            
            res.add(sum);
            
            idx--;
            k /= 10;
        }
        
        Collections.reverse(res);
        return res;
    }
}

//using linkedlist
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList <Integer> res = new LinkedList<>();
        
        int idx = num.length - 1;
        int carry = 0;
        while(idx >= 0 || k > 0 || carry != 0){
            int d1 = idx >= 0 ? num[idx] : 0;
            int d2 = k % 10;
            
            int sum = (d1 + d2 + carry) % 10;
            carry = (d1 + d2 + carry) / 10;
            
            res.addFirst(sum);
            
            idx--;
            k /= 10;
        }
        
        return res;
    }
}
