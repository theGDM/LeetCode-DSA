//jisko sabse kam baar use kiya gaya ho, use remove kiya hai 
class LFUCache {
    public class Node{
        int key;
        int value;
        int freq;
        Node next;
        Node prev;
    }
    
    public class LL{
        Node head;
        Node tail;
        int size;
        
        LL(){
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
    }
    
    public void addFirst(LL list, Node node){
        Node m1 = list.head; //khudse ek peeche ki node
        Node p1 = list.head.next; //khudse ek annge ki node
        
        node.prev = m1;
        node.next = p1;
        
        m1.next = node;
        p1.prev = node;
        list.size++;
    }
    
    public void remove(LL list, Node node){
        Node m1 = node.prev; //khudse ek peeche ki node (minus 1)
        Node p1 = node.next; //khudse ek annge ki node (plus 1)
        
        m1.next = p1;
        p1.prev = m1;
        list.size--;
    }
    
    int cap, min;
    HashMap<Integer, Node> nodemap;// key -> Node
    HashMap<Integer, LL> listmap; // Frequency -> Address of LL
    public LFUCache(int capacity) {
        cap = capacity;
        min = 1;
        nodemap = new HashMap<>();
        listmap = new HashMap<>();
    }
    
    public int get(int key) {
        if(cap == 0) return -1;
        
        if(nodemap.containsKey(key) == false){
            return -1;
        }else{
            Node node = nodemap.get(key);
            //remove from the list in which it was present and add in one higher that this
            LL list1 = listmap.get(node.freq);
            remove(list1, node);
            if(list1.size == 0 && min == node.freq){
                listmap.remove(min);
                min++;
            }
            
            node.freq++; //now increase frequency
            LL list2;
            if(listmap.containsKey(node.freq) == false){
                list2 = new LL();
                listmap.put(node.freq, list2);
            }else{
                list2 = listmap.get(node.freq);
            }
            addFirst(list2, node);
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        if(cap == 0) return;
        
        if(nodemap.containsKey(key) == false){
            if(nodemap.size() == cap){
                LL list1 = listmap.get(min);
                Node remnode = list1.tail.prev;
                nodemap.remove(remnode.key); //remove from nodemap
                remove(list1, remnode);
                if(list1.size == 0 && min == remnode.freq){
                    listmap.remove(min);
                    min++;
                } 
            }
            
            Node node = new Node();
            node.key = key;
            node.value = value;
            node.freq = 1;
            min = 1;
            
            LL list2;
            if(listmap.containsKey(node.freq) == false){
                list2 = new LL();
                listmap.put(node.freq, list2);
            }else{
                list2 = listmap.get(node.freq);
            }
            addFirst(list2, node);
            nodemap.put(key, node);
        }else{
            Node node = nodemap.get(key);
            //remove from the list in which it was present and add in one higher that this
            LL list1 = listmap.get(node.freq);
            remove(list1, node);
            if(list1.size == 0 && min == node.freq){
                listmap.remove(min);
                min++;
            }
            
            node.freq++; //now increase frequency
            LL list2;
            if(listmap.containsKey(node.freq) == false){
                list2 = new LL();
                listmap.put(node.freq, list2);
            }else{
                list2 = listmap.get(node.freq);
            }
            addFirst(list2, node);
            node.value = value;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

//Optimized Code
//jisko sabse kam baar use kiya gaya ho, use remove kiya hai 
class LFUCache {
    public class Node{
        int key;
        int value;
        int freq;
        Node next;
        Node prev;
        
        Node(){};
        Node(int key, int value, int freq){
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }
    
    public class LL{
        Node head;
        Node tail;
        int size;
        
        LL(){
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
    }
    
    public void addFirst(Node node){
        LL list;
        if(listmap.containsKey(node.freq) == false){
            list = new LL();
            listmap.put(node.freq, list);
        }else{
            list = listmap.get(node.freq);
        }
        
        Node m1 = list.head; //khudse ek peeche ki node
        Node p1 = list.head.next; //khudse ek annge ki node
        
        node.prev = m1;
        node.next = p1;
        
        m1.next = node;
        p1.prev = node;
        list.size++;
    }
    
    public void remove(Node node){
        
        LL list = listmap.get(node.freq);
        
        Node m1 = node.prev; //khudse ek peeche ki node (minus 1)
        Node p1 = node.next; //khudse ek annge ki node (plus 1)
        m1.next = p1;
        p1.prev = m1;
    
        list.size--;
        if(list.size == 0 && min == node.freq){
            listmap.remove(min);
            min++;
        }
    }
    
    int cap, min;
    HashMap<Integer, Node> nodemap;// key -> Node
    HashMap<Integer, LL> listmap; // Frequency -> Address of LL
    public LFUCache(int capacity) {
        cap = capacity;
        min = 1;
        nodemap = new HashMap<>();
        listmap = new HashMap<>();
    }
    
    public int get(int key) {
        if(cap == 0) return -1;
        
        if(nodemap.containsKey(key) == false){
            return -1;
        }else{
            Node node = nodemap.get(key);
            //remove from the list in which it was present and add in one higher that this
            remove(node); //remove from previous list
            node.freq++; //now increase frequency
            addFirst(node); //add to new list
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        if(cap == 0) return; //edge case
        
        if(nodemap.containsKey(key) == false){
            if(nodemap.size() == cap){
                LL list1 = listmap.get(min);
                Node remnode = list1.tail.prev;
                nodemap.remove(remnode.key); //remove from nodemap
                remove(remnode);
            }
            
            Node node = new Node(key, value, 1);
            min = 1;
            
            addFirst(node);
            nodemap.put(key, node);
        }else{
            Node node = nodemap.get(key);
            //remove from the list in which it was present and add in one higher that this
            remove(node);
            node.freq++; //now increase frequency
            addFirst(node);
            node.value = value;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
