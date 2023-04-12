class MagicDictionary {
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
    public MagicDictionary() {
        root = new Node();
    }
    
    public void buildDict(String[] dictionary) {
        for(int i = 0; i < dictionary.length; ++i){
            String word = dictionary[i];
            insert(word);
        }
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
    
    public boolean search(String searchWord) {
        return search(0, searchWord, root, false);
    }
    
    public boolean search(int idx, String word, Node curr, boolean change){
        if(idx == word.length()){
            if(change && curr.getEnd()){
                return true;
            }else{
                return false;
            }
        }
        
        char ch = word.charAt(idx);
        if(curr.contains(ch) == true){
            boolean tempAns = search(idx + 1, word, curr.get(ch), change);
            if(tempAns) return true;
        }
        
        if(change == true){ //if already one change applied
            return false;
        }else{ //else replace with any other character no equals to ch, and present in curr node
            for(char nch = 'a'; nch <= 'z'; ++nch){
                if(nch == ch) continue;
                
                if(curr.contains(nch) == true){
                    boolean tempAns  = search(idx + 1, word, curr.get(nch), true);
                    if(tempAns) return true;
                }
            }

            return false;
        }
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
