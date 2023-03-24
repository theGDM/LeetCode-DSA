class GfG{
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
    
    public static void insert(Node curr, String word){
        for(int i = 0; i < word.length(); ++i){
            char ch = word.charAt(i);
            if(curr.contains(ch) == false){
                curr.set(ch);
            }
            
            curr = curr.get(ch);
        }
        
        curr.setEnd();
    }
    
    public static int DFS(Node curr){
        int ans = 0;
        for(char ch = 'a'; ch <= 'z'; ++ch){
            if(curr.contains(ch) == true){
                ans += DFS(curr.get(ch));
            }
        }
        
        return ans + 1;
    }
    
    public static int countDistinctSubstring(String st){
        Node root = new Node();
        for(int i = 0; i < st.length(); ++i){
            String word = st.substring(i);
            insert(root, word);
        }
        
        return DFS(root);
    }
}
