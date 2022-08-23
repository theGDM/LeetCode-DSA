class NumArray {
    int[] arr;
    public NumArray(int[] nums) {
        arr = nums;
    }
    
    //O(1)
    public void update(int index, int val) {
        arr[index] = val;
    }
    
    //O(n)
    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i = left; i <= right; ++i){
            sum += arr[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */


//it works for point update and range query
//not fit for range update and range query
//can be implemnted using segment tree, so that we will have the update operation with TC : O(log(n))
//and rangeSum operation with TC : O(log(n));
//Overall TC : nlog(n)
//kisi bhi level per 4 se zyada query visit nahi hogi, kyuki we need continuous range
class NumArray {
    public class Node{
        int st;
        int en;
        
        int val;
        Node left;
        Node right;
    }
    
    Node root;
    public NumArray(int[] nums) {
        root = construct(0, nums.length - 1, nums);
    }
    
    //O(n) //One time operation
    public Node construct(int lo, int hi, int[] nums){
        if(lo == hi){ //base case
            Node node = new Node();
            node.st = lo;
            node.en = hi;
            node.val = nums[lo];
            node.left = node.right = null;
            return node;
        }
        
        Node node = new Node();
        node.st = lo;
        node.en = hi;
        
        int mid = lo + (hi - lo) / 2;
        node.left = construct(lo, mid, nums);
        node.right = construct(mid + 1, hi, nums);
        node.val = node.left.val + node.right.val; //update val of node in postorder
        
        return node;
    }
    
    public void update(int index, int val) {
        updateHelper(index, val, root);
    }
    
    //O(log(n))
    public void updateHelper(int idx, int val, Node node){
        if(node.st == node.en){
            node.val = val;
            return;
        }
        
        int mid = (node.st + node.en) / 2;
        if(idx <= mid){
            updateHelper(idx, val, node.left);
        }else{
            updateHelper(idx, val, node.right);
        }
        
        node.val = node.left.val + node.right.val; //make correction in
    }
    
    public int sumRange(int left, int right) {
        return query(left, right, root);
    }
    
    //O(log(n))
    public int query(int qs, int qe, Node node){
        if(node == null || qs > node.en || qe < node.st){ //None - overlapping case
            return 0;
        }else if(node.st >= qs && node.en <= qe){
            return node.val;
        }else{
            int lval = query(qs, qe, node.left);
            int rval = query(qs, qe, node.right);
            
            return lval + rval;
        }
        
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
