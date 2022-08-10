//we can not sort as relative order does matter
class Solution { //so that we do not lost the original index after sorting perform
    int[] res;
    public class Pair{
        int val;
        int idx;
        
        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        //array of pair, having val + idx
        Pair[] pairs = new Pair[nums.length];
        
        for(int i = 0; i < nums.length; ++i){
            pairs[i] = new Pair(nums[i], i);
        }
        
        res = new int[nums.length];
        
        //applying merge sort
        mergeSort(0, nums.length - 1, pairs);
        
        List<Integer> ans = new ArrayList<>();
        for(int val : res){
            ans.add(val);
        }
        
        return ans;
    }
    
    //TC : O(nlog(n)) //sc: O(n)
    public Pair[] mergeSort(int lo, int hi, Pair[] pairs){
        if(lo == hi){
            Pair[] ba = new Pair[1];
            ba[0] = new Pair(pairs[lo].val, lo);
            return ba;
        }
        
        int mid = lo + (hi - lo) / 2;
        
        Pair[] fh = mergeSort(lo, mid, pairs);
        Pair[] sh = mergeSort(mid + 1, hi, pairs);
        
        return merge2SortedArray(fh, sh);
    }
    
    //TC : O(n1 + n2) //SC : O(n1 + n2)
    public Pair[] merge2SortedArray(Pair[] a, Pair[] b){
        int i = 0;
        int j = 0;
        int k = 0;
        Pair[] merged = new Pair[a.length + b.length];
        
        while(i < a.length && j < b.length){
            if(a[i].val > b[j].val){
                res[a[i].idx] += b.length - j; //main task
                merged[k++] = a[i++];
            }else{
                merged[k++] = b[j++];
            }
        }
        
        if(i < a.length){
            while(i < a.length){
                merged[k++] = a[i++];
            }
        }
        
        if(j < b.length){
            while(j < b.length){
                merged[k++] = b[j++];
            }
        }
        
        return merged;
    }
}
