//Using prefix sum
class MapSum {
    public static class Node{
        private Node[] children = new Node[26];
        private int val = 0;
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
        
        public int getVal(){
            return val;
        }
        
        public void setVal(int val){
            this.val = val;
        }
        
        public int getPref(){
            return prefix;
        }
        
        public void setPref(int prefix){
            this.prefix = prefix;
        }
    }
    
    Node root;
    public MapSum() {
        root = new Node();
    }
    
    public void insert(String key, int val) {
        int oldVal = search(key);
        
        Node curr = root;
        for(int i = 0; i < key.length(); ++i){
            curr.setPref(curr.getPref() + val - oldVal);
            char ch = key.charAt(i);
            if(curr.contains(ch) == false){
                curr.set(ch);
            }
            
            curr = curr.get(ch);
        }
        
        curr.setPref(curr.getPref() + val - oldVal);
        curr.setVal(val);
    }
    
    public int search(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); ++i){
            char ch = word.charAt(i);
            if(curr.contains(ch) == false){
                return 0;
            }
            
            curr = curr.get(ch);
        }
        
        return curr.getVal();
    }
    
    public int sum(String prefix) {
        Node curr = root;
        for(int i = 0; i < prefix.length(); ++i){
            char ch = prefix.charAt(i);
            if(curr.contains(ch) == false){
                return 0;
            }
            
            curr = curr.get(ch);
        }
        
        return curr.getPref();
    }
}

//Using DFS
class MapSum {
    public static class Node{
        private Node[] children = new Node[26];
        private int val = 0;
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null) ? true : false;
        }
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public void set(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public int getVal(){
            return val;
        }
        
        public void setVal(int val){
            this.val = val;
        }
    }
    
    Node root;
    public MapSum() {
        root = new Node();
    }
    
    //O(L)
    public void insert(String key, int val) {
        Node curr = root;
        for(int i = 0; i < key.length(); ++i){
            char ch = key.charAt(i);
            if(curr.contains(ch) == false){
                curr.set(ch);
            }
            
            curr = curr.get(ch);
        }
        
        curr.setVal(val);
    }
    
    public int sum(String prefix) {
        Node curr = root;
        for(int i = 0; i < prefix.length(); ++i){
            char ch = prefix.charAt(i);
            if(curr.contains(ch) == false){
                return 0;
            }
            
            curr = curr.get(ch);
        }
        
        return DFS(curr);
    }
    
    public int DFS(Node curr){
        int sum = 0;
        for(char ch = 'a'; ch <= 'z'; ++ch){
            if(curr.contains(ch) == true){
                sum += DFS(curr.get(ch));
            }
        }
        
        return sum + curr.getVal();
    }
}
