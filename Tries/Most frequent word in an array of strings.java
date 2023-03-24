//if more than one answers are allowed
class Solution{
    public static class Node{
        private Node[] children = new Node[26];
        private int isEnd = 0;
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null) ? true : false;
        }
        
        public Node get(char ch){
            return children[ch - 'a']; 
        }
        
        public void set(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public int getEnd(){
            return isEnd;
        }
        
        public void increaseFreq(){
            isEnd++;
        }
        
        public void decreaseFreq(){
            isEnd--;
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
        
        curr.increaseFreq();
    }
    
    
    String res = "";
    int maxFreq = 0;
    public String mostFrequentWord(String arr[], int n){
        Node root = new Node();
        for(String word : arr){
            insert(root, word);
        }
        
        DFS(root, "");
        return res;
    }
    
    public void DFS(Node curr, String str){
        if(curr.getEnd() >= maxFreq){
            maxFreq = curr.getEnd();
            res = str;
        }
    
        for(char ch = 'a'; ch <= 'z'; ++ch){
            if(curr.contains(ch) == true){
                DFS(curr.get(ch), str + ch);
            }
        }
    }
}

//Littel diffrent way
class Solution{
    public static class Node{
        private Node[] children = new Node[26];
        private int isEnd = 0;
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null) ? true : false;
        }
        
        public Node get(char ch){
            return children[ch - 'a']; 
        }
        
        public void set(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public int getEnd(){
            return isEnd;
        }
        
        public void increaseFreq(){
            isEnd++;
        }
        
        public void decreaseFreq(){
            isEnd--;
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
        
        curr.increaseFreq();
    }
    
    
    String res = "";
    int maxFreq = 0;
    public String mostFrequentWord(String arr[], int n){
        Node root = new Node();
        for(String word : arr){
            insert(root, word);
        }
        
        HashSet<String> set = new HashSet<>();
        for(String word : arr){
            if(set.contains(word) == false){
                int freq = getFreq(root, word);
                if(freq >= maxFreq){
                    maxFreq = freq;
                    res = word;
                }
            }
            
            set.add(word);
        }
        
        return res;
    }
    
    public int getFreq(Node curr, String word){
        for(int i = 0; i < word.length(); ++i){
            char ch = word.charAt(i);
            curr = curr.get(ch);
        }
        
        return curr.getEnd();
    }
}
