/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//Using PriorityQueue
class Solution {
    public class Pair implements Comparable<Pair>{
        TreeNode node;
        int hl;
        int vl;
        
        Pair(TreeNode node, int hl, int vl){
            this.node = node;
            this.hl = hl;
            this.vl = vl;
        }
        
        public int compareTo(Pair O){
            if(this.hl == O.hl){
                return this.node.val - O.node.val;
            }else{
                return this.hl - O.hl; //chhota pahle aayega, bada baad me aayega
            }
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, PriorityQueue<Pair>> hm = new HashMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0, 0));
      
        int minl = 0;
        int maxr = 0;
      
        List<List<Integer>> res = new ArrayList<>();
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
                Pair rem = q.remove(); //remove
                
                minl = Math.min(minl, rem.vl); //work1
                maxr = Math.max(maxr, rem.vl);
                
                if(hm.containsKey(rem.vl) == false){ //work2
                    hm.put(rem.vl, new PriorityQueue<>());
                }
                hm.get(rem.vl).add(rem);
                
                if(rem.node.left != null){ //add left child of remove node
                    q.add(new Pair(rem.node.left, rem.hl + 1, rem.vl - 1)) ;
                }
                
                if(rem.node.right != null){ //add right child of remove node
                    q.add(new Pair(rem.node.right, rem.hl + 1, rem.vl + 1));
                }
            }   
        }
        
        for(int i = minl; i <= maxr; ++i){
            PriorityQueue pq = hm.get(i);
            List<Integer> part = new ArrayList<>();
            while(pq.size() > 0){
                Pair p = (Pair)pq.remove();
                part.add(p.node.val);
            }
            res.add(part);
        }
        
        return res;
    }
}

//Using ArrayList
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public class Pair implements Comparable<Pair>{
        TreeNode node;
        int hl;
        int vl;
        
        Pair(TreeNode node, int hl, int vl){
            this.node = node;
            this.hl = hl;
            this.vl = vl;
        }
        
        public int compareTo(Pair O){
            if(this.hl == O.hl){
                return this.node.val - O.node.val;
            }else{
                return this.hl - O.hl; //chhota pahle aayega, bada baad me aayega
            }
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, ArrayList<Pair>> hm = new HashMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0, 0));

        int minl = 0;
        int maxr = 0;
        
        List<List<Integer>> res = new ArrayList<>();
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
                Pair rem = q.remove(); //remove
                
                minl = Math.min(minl, rem.vl); //work1
                maxr = Math.max(maxr, rem.vl);
                
                if(hm.containsKey(rem.vl) == false){ //work2
                    hm.put(rem.vl, new ArrayList<>());
                }
                hm.get(rem.vl).add(rem);
                
                if(rem.node.left != null){ //add left child of remove node
                    q.add(new Pair(rem.node.left, rem.hl + 1, rem.vl - 1)) ;
                }
                
                if(rem.node.right != null){ //add right child of remove node
                    q.add(new Pair(rem.node.right, rem.hl + 1, rem.vl + 1));
                }
            }   
        }
        
        
        for(int i = minl; i <= maxr; ++i){
            ArrayList unsortedList = hm.get(i);
            List<Integer> part = new ArrayList<>();
            Collections.sort(unsortedList); //if you are sorting the array of pair, you need to implement
                                            //the comparable
            for(int j = 0; j < unsortedList.size(); ++j){
                Pair p = (Pair)unsortedList.get(j);
                part.add(p.node.val);
            }
            res.add(part);
        }
        
        return res;
    }
}
