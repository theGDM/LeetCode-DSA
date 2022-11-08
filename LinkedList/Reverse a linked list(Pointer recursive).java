//Pointer Recursive approch
//TC : O(N)
class Solution{
    //Function to reverse a linked list.
    
    Node reverseList(Node head){
        Node tail = getTail(head);
        reverseHelper(head);
        head.next = null;
        return tail;
    }
    
    public void reverseHelper(Node head){
        if(head == null || head.next == null){//base case
            return;
        }
        
        //faith call
        reverseHelper(head.next);
        //post order link update
        head.next.next = head;
    }
    
    static Node getTail(Node head){
        while(head.next != null){
            head = head.next;
        }
        
        return head;
    }
}
