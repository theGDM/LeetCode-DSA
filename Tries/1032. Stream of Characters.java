class StreamChecker {
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
    

    //O(L)
    public void insert(String word, Node curr) {
        for(int i = word.length() - 1; i >= 0; --i){
            char ch = word.charAt(i);
            if(curr.contains(ch) == false){
                curr.set(ch);
            }
              
            curr = curr.get(ch);
        }
        
        curr.setEnd(); //end of the word
    }
    
    Node root;
    StringBuilder sb = new StringBuilder();
    public StreamChecker(String[] words) {
        root = new Node();
        for(String word : words){
            insert(word, root);
        }
    }
    
    public boolean isPrefix(StringBuilder sb){
        Node curr = root;
        for(int i = sb.length() - 1; i >= 0; --i){
            char ch = sb.charAt(i);
            if(curr.getEnd() == true) return true;
            if(curr.contains(ch) == false){
                return false;
            }
            
            curr = curr.get(ch);
        }
        
        return curr.getEnd(); //important
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        return isPrefix(sb);
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
