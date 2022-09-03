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
    HashMap<Node, Node> hm = new HashMap<>();
    //original node -> duplicate node
    public Node copyRandomList(Node head) {
        //creation of deep copy linked list
        Node tempHead = helper(head); //getting head of the copy of the linkedlist(deep copy), without random p
        
        Node tempH = tempHead;
        while(head != null){
            Node randomNode = head.random; //get random pointer of current head node
            Node temp = hm.get(randomNode); //find its corresponding node in hm
            tempHead.random = temp;
            
            head = head.next;
            tempHead = tempHead.next;
        }
        
        return tempH;
    }
    
    public Node helper(Node root){
        if(root == null){
            return null;
        }
        
        Node temp = helper(root.next);
        
        Node newNode = new Node(root.val);
        newNode.next = temp;
        hm.put(root, newNode);
        
        return newNode;
    }
}
