//Brute force using HM
//TC : O(N * m), m is the length of the maximum size word, N is size of words array
class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        HashMap<String, Integer> map = new HashMap<>();
        for(String str : words){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        String ans = "";
        for(int i = 0; i < words.length; ++i){
            String word = words[i], curr = "";
            for(int j = 0; j < word.length(); ++j){
                String part = word.substring(0, j + 1);
                if(map.containsKey(part)){
                    curr = part;
                }else{
                    break;
                }
            }
            
            if(curr.length() > ans.length()){
                ans = curr;
            }
        }
        
        return ans;
    }
}

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
    
    //O(n * L), n is the average characters in a string, and there are L strings
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
