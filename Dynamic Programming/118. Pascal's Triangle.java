//TC : 1 * 1 + 1 * 2 + 1 * 3 + 1 * 4 + 1 * 5 ... 1 * n = n(n + 1)/2 ~ O(n * n)
//SC : O(n * n)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList(Arrays.asList(1)));
        for(int i = 1; i < numRows; ++i){
            List<Integer> prev = res.get(i - 1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1); //add starting 1
            int c = prev.get(0);
            for(int j = 1; j < prev.size(); ++j){
                int t = c + prev.get(j);
                curr.add(t);
                c = prev.get(j); //update c to jth value of prev list
            }
            curr.add(1); //add ending 1
            res.add(curr);//add to the res array
        }
        return res;
    }
}
