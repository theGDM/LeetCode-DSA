/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

//TC : O(n)
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap<>();
        //original node -> duplicate node
        
        Node copyHead = new Node(-1);
        Node tail = copyHead;
        
        Node original = head;
        while(original != null){
            Node temp = new Node(original.val);
            tail.next = temp;
            tail = temp;
            hm.put(original, temp);
            original = original.next;
        }
        
        original = head;
        while(original != null){
            Node randomNode = original.random;
            hm.get(original).random = hm.get(randomNode); //if randomNode == null, then we will get null
            original = original.next;                     //from hm, as it will not be present inside of it
        }
        
        return copyHead.next;
    }  
}

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

//TC : O(3n)
//SC : O(1)
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Node original = head; //insert duplicate nodes in between
        while(original != null){
            Node temp = new Node(original.val);
            
            temp.next = original.next;
            original.next = temp;
            original = temp.next; //move original pointer
        }
        
        original = head;
        //updating the random of the duplicate linkedlist
        while(original != null){
            Node randomNode = original.random;
            if(original.random != null) randomNode = randomNode.next;
            original.next.random = randomNode;
            original = original.next.next;
        }
        
        original = head;
        Node copyHead = head.next;
        
        //segreggeting the original and duplicate linked list
        while(original != null){
            Node duplicate = original.next;
            original.next = duplicate.next;
            
            if(duplicate.next != null){
                duplicate.next = duplicate.next.next;
            }
            
            original = original.next;
        }
        
        return copyHead;
    }  
}
