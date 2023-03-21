class WordDictionary {
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
    public WordDictionary() {
        root = new Node();
    }
    
    //O(L)
    public void addWord(String word) {
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
    
    //O(26^L)
    public boolean search(String word, int idx, Node curr){
        if(idx == word.length()){ //base case
            return curr.getEnd();
        }
        
        char ch = word.charAt(idx);
        if(ch == '.'){
            for(int i = 0; i < 26; ++i){
                char tempCh = (char)(i + 'a');
                if(curr.contains(tempCh) != false){
                    boolean tempAns = search(word, idx + 1, curr.get(tempCh));
                    if(tempAns) return true; //just to save some iterations
                }
            }
            
            return false;
        }else if(curr.contains(ch) == true){ //ch is found in the children array of curr node
            return search(word, idx + 1, curr.get(ch));
        }else{ //ch is found in the children array of curr node
            return false;
        }
    }
    
    public boolean search(String word) {
        return search(word, 0, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
