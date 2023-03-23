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
    
    //O(N), N is the length of one string
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

    public String searchPref(int idx, Node curr, String word, String str){
        if(idx == word.length()){
            return curr.getEnd() == false ? "" : str;
        }
        
        if(curr.getEnd() == true){
            return str;
        }
        
        char ch = word.charAt(idx);
        if(curr.contains(ch) == true){
            return searchPref(idx + 1, curr.get(ch), word, str + ch);
        }
        
        return curr.getEnd() == false ? "" : str;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        for(int i = 0; i < dictionary.size(); ++i){
            String word = dictionary.get(i);
            insert(word);
        }
        
        String[] words = sentence.split(" ");
        String res = "";
        for(int i = 0; i < words.length; ++i){
            String word = words[i];
            String prefix = searchPref(0, root, word, "");
            if(prefix == ""){
                res = res + word + " ";
            }else{
                res = res + prefix + " ";
            }
        }
        
        return res.substring(0, res.length() - 1);
    }
}

//Optimized solution
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
    
    public void insert(Node curr, String word){
        for(int i = 0; i < word.length(); ++i){
            char ch = word.charAt(i);
            if(curr.contains(ch) == false){
                curr.set(ch);
            }
            
            curr = curr.get(ch);
        }
        
        curr.setEnd();
    }
     
    public String search(Node curr, String word){
        for(int i = 0; i < word.length(); ++i){
            char ch = word.charAt(i);
            
            if(curr.getEnd() == true){
                return word.substring(0, i);
            }
            
            if(curr.contains(ch) == false){
                return word;
            }
            
            curr = curr.get(ch);
        }
        
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node();
        for(int i = 0; i < dictionary.size(); ++i){
            String word = dictionary.get(i);
            insert(root, word);
        }
        
        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < words.length; ++i){
            String word = words[i];
            String prefix = search(root, word);
            res.append(prefix);
            res.append(" ");
        }
        
        return res.toString().substring(0, res.length() - 1);
    }
}
