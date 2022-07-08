import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] sentence1 = br.readLine().split(" ");
    String[] sentence2 = br.readLine().split(" ");

    int m = Integer.parseInt(br.readLine());

    String[][] pairs = new String[m][2];
    for (int i = 0; i < m; i++) {
      pairs[i] = br.readLine().split(" ");
    }

    System.out.println(areSentencesSimilarTwo(sentence1, sentence2, pairs));

  }

  public static HashMap<String, String> parent;
  public static HashMap<String, Integer> rank;
  public static boolean areSentencesSimilarTwo(String[] Sentence1, String[] Sentence2, String[][] pairs) {
    parent = new HashMap<>();
    rank = new HashMap<>();

    for (String[] pair : pairs) {
      String w1 = pair[0];
      String w2 = pair[1];

      if (parent.containsKey(w1) == false) {
        parent.put(w1, w1);
        rank.put(w1, 0);
      }

      if (parent.containsKey(w2) == false) {
        parent.put(w2, w2);
        rank.put(w2, 0);
      }
    }

    for (String[] pair : pairs) {
      String w1 = pair[0];
      String w2 = pair[1];

      String w1l = find(w1);
      String w2l = find(w2);

      if (w1l.equals(w2l) == false) {
        union(w1l, w2l);
      }
    }
    
    // System.out.println(parent);

    if(Sentence1.length != Sentence2.length){
        return false;
    }
    
    for(int i = 0; i < Sentence1.length; i++){
        String w1 = Sentence1[i];
        String w2 = Sentence2[i];
        
        if(w1.equals(w2)){ //if w1 equlas w2, the continue
            continue;
        } else if(parent.containsKey(w1) == false  || parent.containsKey(w2) == false){
            return false; //if any w1 and w2 are different and, either of them is not in hashmap
        }                 //then return false
        
        String w1l = find(w1);
        String w2l = find(w2);
        if(w1l.equals(w2l) == false){
            return false;
        }
    }
    
    return true;
  }

  public static String find(String x) {
    if (parent.get(x).equals(x)) {
      return parent.get(x);
    } else {
      String pox = parent.get(x);
      String setLead = find(pox);
      parent.put(x, setLead);
      return setLead;
    }
  }

  public static void union(String xl, String yl) {
    if (rank.get(xl) < rank.get(yl)) {
      parent.put(xl, yl);
    } else if (rank.get(yl) < rank.get(xl)) {
      parent.put(yl, xl);
    } else {
      parent.put(xl, yl);
      rank.put(yl, rank.get(yl) + 1);
    }
  }

}
