class Solution{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        
        if(head == null || head.next == null){
            return;
        }
        
        Node slow = head; 
        Node fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break; //cycle detected
        }
        
        if(fast == null || fast.next == null) return;//SLL
        
        //it is the case of circular linked list
        if(slow == fast && slow == head){ 
            while(slow.next != head){
                slow = slow.next;
            }
            
            slow.next = null;
            return;
        }
        
        Node curr1 = slow;
        Node curr2 = head;
        
        int len = 0;
        while(curr1.next != curr2.next){
            len++;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        curr1.next = null;
        // while(len-- > 1){
        //     slow = slow.next;
        // }
        
        // slow.next = null;
    }
}
