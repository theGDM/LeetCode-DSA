class Solution {
    public static class Node{
        private Node[] children = new Node[26];
        private boolean isEnd = false;
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null) ? true : false;
        }
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public void set(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public boolean getEnd(){
            return isEnd;
        }
        
        public void setEnd(){
            isEnd = true;
        }
    } 
    
    Node root;
    public Solution() {
        root = new Node();
    }
    
    //O(L)
    public void insert(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); ++i){
            char ch = word.charAt(i);
            if(curr.contains(ch) == false){
                curr.set(ch);
            }
              
            curr = curr.get(ch);
        }
        
        curr.setEnd(); //end of the word
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for(int i = 0; i < products.length; ++i){
            String word = products[i];
            insert(word);
        }
        
        Node curr = root;
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < searchWord.length(); ++i){
            char ch = searchWord.charAt(i);
            if(curr.contains(ch) == true){
                curr = curr.get(ch);
                String pref = searchWord.substring(0, i + 1);
                List<String> part = new ArrayList<>();
                DFS(pref, curr, part, 3);
                res.add(part);
            }else{
                break;
            }
            
        }
        
        while(res.size() < searchWord.length()){
            res.add(new ArrayList<>());
        }
        
        return res;
    }
    
    public void DFS(String word, Node curr, List<String> part, int k){
        if(part.size() == k){
            return;
        }
        
        if(curr.getEnd() == true){
            part.add(word);
        }
        
        for(char ch = 'a'; ch <= 'z'; ++ch){
            if(curr.contains(ch) == true){        
                DFS(word + ch, curr.get(ch), part, k);
            }
        }
    }
}
