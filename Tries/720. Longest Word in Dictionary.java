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
    public void insert(String word){
        Node curr = root;
        for(int i = 0; i < word.length(); ++i){
            char ch = word.charAt(i);
            if(curr.contains(ch) == false){
                curr.set(ch);
            }
            
            curr = curr.get(ch);
        }
        
        curr.setEnd();
    }
    
    String ans = "";
    public String longestWord(String[] words) {
        //making the trie for the words
        for(int i = 0; i < words.length; ++i){
            String word = words[i];
            insert(word);
        }
        
        root.setEnd(); //important, for the base case
        DFS(root, "");
        return ans;
    }
    
    //TC : O(∑wi), where wi is the length of words[i]. This is the TC to build thE trie and to search it, or
    //O(n * N), n is the average characters in a string, and there are N strings
    public void DFS(Node curr, String str){
        if(curr.getEnd() == false){
            return;
        }
        
        //preorder work
        if(str.length() > ans.length()){
            ans = str;
        }
        
        for(char ch = 'a'; ch <= 'z'; ++ch){
            if(curr.contains(ch) == true){
                DFS(curr.get(ch), str + ch);
            }
        }
    }
}
