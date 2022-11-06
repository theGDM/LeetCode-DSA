/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

//TC : O(N), as we are visiting each and every node
class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;
        
        Node dummy = new Node();
        dummy.val = -1;
        Node dTail = dummy, dHead = dummy;
        Node curr = head;
        Stack<Node> stk = new Stack<>();
        
        while(curr != null){
            dTail.next = curr;
            curr.prev = dTail;
            dTail = dTail.next;
            
            if(curr.child == null){
                curr = curr.next;
            }else{
                stk.add(curr.next); //add in stack, so we can refer it letter
                curr = curr.child;
                dTail.child = null; //very important to make it fully, doubly LL 
            }
        }
        
        while(stk.size() > 0){
            Node p = stk.pop();
            
            while(p != null){
                dTail.next = p;
                p.prev = dTail;
                dTail = dTail.next;
                p = p.next;
            }
        }
        
        dHead.next.prev = null; //Otherwise, The linked list [1,2,3,7,8,11,12,9,10,4,5,6] is not a valid doubly linked list.
        return dHead.next;
    }
}
