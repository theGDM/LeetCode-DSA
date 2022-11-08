//TC : O(n)
class gfg{
	void splitList(circular_LinkedList list){
	    //edge cases
        if(list.head == null){
            return;
        }else if(list.head.next == list.head){ //self referential node (1 node)
            list.head1 = list.head;
            list.head2 = null;
            return;
        }
        
        Node slow = list.head, fast = list.head;
        while(fast.next != list.head && fast.next.next != list.head){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        list.head1 = list.head;
        list.head2 = slow.next;
        slow.next = list.head1; //making first part circular
        if(fast.next == list.head){ //odd case
            fast.next = list.head2; //making 2nd part circular
        }else{ //even case, fast.next.next == list.head
            fast.next.next = list.head2;
        }
	}
}
