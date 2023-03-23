class Solution {
    public String longestCommonPrefix(String[] strs) {
        //finding smallest string
        int min = Integer.MAX_VALUE;
        String smallStr = "";
        for(int i = 0;i < strs.length; ++i){
            if(strs[i].length() < min){
                smallStr = strs[i];
                min = strs[i].length();
            }
        }
        
        String ans = "";
        for(int i = 0; i < smallStr.length(); ++i){
            String sub = smallStr.substring(0, i + 1);
            for(int j = 0;j < strs.length; ++j){
                if(!sub.equals(strs[j].substring(0, i + 1))){
                    return ans;
                }
            }
            ans = sub; // now update the ans, as the current substr
        }
        return ans;
    }
}

//Horizontal scanning
//TC : O(n * m), m is max length word
class Solution {
    public String longestCommonPrefix(String[] strs) {
        //Horizontal scanning
        if(strs.length == 1) return strs[0];
        
        String first = strs[0], res = "";
        for(int i = 1; i < strs.length; ++i){
            String second = strs[i];
            int j = 0, k = 0;
        
            while(j < first.length() && k < second.length()){
                if(first.charAt(j) != second.charAt(k)){
                    break;
                }
                j++; k++;
            }
            
            res = first.substring(0, j);
            first = res;
        }
        
        return res;
    }
}

//Trie
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
    
    public String longestCommonPrefix(String[] strs) {
        Node root = new Node();
        for(String word : strs){
            insert(root, word);
        }
        
        return DFS(root);
    }
    
    public String DFS(Node curr){
        if(curr.getEnd() == true){
            return "";
        }
        
        int count = 0;
        char child = 'a';
        for(char ch = 'a'; ch <= 'z'; ++ch){
            if(curr.contains(ch) == true){
                count++;
                child = ch;
            }
        }
        
        if(count == 1){ //current node have single child
            return child + DFS(curr.get(child));
        }else{ //current node have 0 child or multiple childs
            return "";
        }
    }
}
