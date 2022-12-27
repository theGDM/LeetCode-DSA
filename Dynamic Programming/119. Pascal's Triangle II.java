class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList(Arrays.asList(1)));
        for(int i = 1; i < (rowIndex + 1); ++i){
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
        
        return res.get(rowIndex);
    }
}
