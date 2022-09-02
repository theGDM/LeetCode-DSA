class LRUCache {
    public class Node{
        int key;
        int val;
        Node prev;
        Node next;
        
        Node(int val){
            this.val = val;
        }
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    HashMap<Integer, Node> map;
    int size;
    int totalSize;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        head = new Node(-1);
        tail = new Node(-1);
        map = new HashMap<>();
        totalSize = capacity;
        size = 0;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            int val = curr.val; //get value
            //remove that node;
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            
            //add first
            curr.prev = head;
            curr.next = head.next;
            curr.prev.next = curr;
            curr.next.prev = curr;
            return val;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key) == false){ //that node is not present
            Node curr = new Node(key, value);
            if(size == totalSize){
                Node temp = tail.prev;
                //delete that node;
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                map.remove(temp.key);
                //add first
                curr.val = value;
                curr.prev = head;
                curr.next = head.next;
                curr.prev.next = curr;
                curr.next.prev = curr;
                map.put(key, curr);
            }else{
                //add first
                curr.prev = head;
                curr.next = head.next;
                curr.prev.next = curr;
                curr.next.prev = curr;
                map.put(key, curr);
                size++; 
            }
        }else if(map.containsKey(key) == true){
            Node curr = map.get(key);
            //delete that node;
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            //add first
            curr.val = value; //update value
            curr.prev = head;
            curr.next = head.next;
            curr.prev.next = curr;
            curr.next.prev = curr;
            map.put(key, curr);  
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
