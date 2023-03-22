import java.util.* ;
import java.io.*; 
public class Trie {
    public static class Node{
        private Node[] children = new Node[26];
        private int prefixCount = 0;
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
        
        public int getFreq(){
            return isEnd;
        }

        public int getPref(){
            return prefixCount;
        }

        public void increaseFreq(){
            isEnd++;
        }

        public void decreaseFreq(){
            isEnd--;
        }
        public void increasePref(){
            prefixCount++;
        }

        public void decreasePref(){
            prefixCount--;
        }
    }

    Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); ++i){
            curr.increasePref(); //shuruatt me hi 
            char ch = word.charAt(i);
            if(curr.contains(ch) == false){
                curr.set(ch);
            }

            curr = curr.get(ch);
        }
        
        curr.increasePref();// last character ke liye 
        curr.increaseFreq();// end of the word
    }

    public int countWordsEqualTo(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); ++i){
            char ch = word.charAt(i);
            if(curr.contains(ch) == false){
                return 0;
            }

            curr = curr.get(ch);
        }
         
        return curr.getFreq(); //return count of that word
    }

    public int countWordsStartingWith(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); ++i){
            char ch = word.charAt(i);
            if(curr.contains(ch) == false){
                return 0;
            }

            curr = curr.get(ch);
        }
        
        return curr.getPref(); //we can not access prefixCount directly using curr, as
                        //it is private, so we need getter
    }

    public void erase(String word) {
        if(countWordsEqualTo(word) == 0){
            return;
        }
        
        Node curr = root;
        for(int i = 0; i < word.length(); ++i){
            curr.decreasePref(); //shuruatt me hi 
            char ch = word.charAt(i);
            curr = curr.get(ch);
        }
        
        curr.decreasePref();// last character ke liye 
        curr.decreaseFreq();
    }

}
