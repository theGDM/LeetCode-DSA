class Solution {
    public static class Node{
        private Node[] children = new Node[26];
        private boolean isEnd = false;
        private int prefix = 0;
        
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
        
        public int getPrefix(){
            return prefix;
        }
        
        public void increasePrefix(){
            prefix++;
        }
        
        public void decreasePrefix(){
            prefix--;
        }
    }
    
    public static Node root;
    public Solution(){
        root = new Node();
    }
    
    public static void insert(String word){
        Node curr = root;
        for(int i = 0; i < word.length(); ++i){
            char ch = word.charAt(i);
            curr.increasePrefix();
            
            if(curr.contains(ch) == false){
                curr.set(ch);
            }
            
            curr = curr.get(ch);
        }
        
        curr.increasePrefix(); //for last node;
        curr.setEnd();
    }
    
    public static String search(String word){
        Node curr = root;
        for(int i = 0; i < word.length(); ++i){
            char ch = word.charAt(i);
            if(curr.getPrefix() == 1){
                return word.substring(0, i);
            }
            
            curr = curr.get(ch);
        }
        
        return word;
    }
    
    static String[] findPrefixes(String[] arr, int N) {
        for(String word : arr){
            insert(word);
        }
        
        String[] res = new String[arr.length];
        for(int i = 0; i < arr.length; ++i){
            String word = arr[i];
            res[i] = search(word);
        }
        
        return res;
    }
};
